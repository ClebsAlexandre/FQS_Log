package springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dtos.OrderRecordDto;
import springboot.model.Order;
import springboot.model.Vehicle;
import springboot.repository.OrderRepository;
import springboot.repository.VehicleRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private VehicleRepository vehicleRepository;



    @PostMapping("/save")
    public ResponseEntity<?> saveOrder(@RequestBody @Valid OrderRecordDto orderRecordDto) {

        var orderModel = new Order();
        BeanUtils.copyProperties(orderRecordDto, orderModel);

        String plate = orderRecordDto.vehiclePlate();

        if (plate != null && !plate.isBlank()) {
            Optional<Vehicle> vehicle = vehicleRepository.findByPlate(plate);

            if (vehicle.isPresent()) {
                orderModel.setVehicle(vehicle.get());
            }
        }

        return ResponseEntity.ok().body(orderRepository.save(orderModel));

    }

    @GetMapping("/search/{recipientCPF}")
    public ResponseEntity<List<Order>> searchByRecipientCPF(@PathVariable(value = "recipientCPF") String recipientCPF) {

        List<Order> orders = orderRepository.findByRecipientCPF(recipientCPF);

        if (orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(orders);

    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeOrder(@PathVariable UUID id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Order deletedOrder = optionalOrder.get();

        Vehicle vehicle = deletedOrder.getVehicle();
        if (vehicle != null) {
            vehicle.getOrders().remove(deletedOrder);
        }

        orderRepository.delete(deletedOrder);
        return ResponseEntity.ok().body(deletedOrder);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Order>> orderList(){
        List<Order> orders = orderRepository.findAll();

        return ResponseEntity.ok().body(orders);
    }

}