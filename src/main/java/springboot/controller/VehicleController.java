package springboot.controller;


import org.springframework.http.HttpStatus;
import springboot.dtos.VehicleRecordDto;
import jakarta.validation.Valid;
import springboot.model.Vehicle;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping("/save")
    public ResponseEntity<?> saveVehicle(@RequestBody @Valid VehicleRecordDto  vehicleRecordDto) {

        var vehicleModel = new Vehicle();
        BeanUtils.copyProperties(vehicleRecordDto, vehicleModel);
        return ResponseEntity.ok().body(vehicleRepository.save(vehicleModel));

    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable UUID id, @RequestBody @Valid VehicleRecordDto  vehicleUpdate) {

        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);

        if(optionalVehicle.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Vehicle vehicle = optionalVehicle.get();

        vehicle.setPlate(vehicleUpdate.plate());
        vehicle.setModel(vehicleUpdate.model());
        vehicle.setCurrentLocalization(vehicleUpdate.currentLocalization());

        vehicleRepository.save(vehicle);

        return ResponseEntity.ok().body(vehicle);

    }

    @DeleteMapping("/remove/{plate}")
    public ResponseEntity<?> removeVehicle(@PathVariable String plate) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByPlate(plate);

        if (optionalVehicle.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado");
        }

        Vehicle deletedVehicle = optionalVehicle.get();
        vehicleRepository.delete(deletedVehicle);

        return ResponseEntity.ok(deletedVehicle);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Vehicle>> vehiclesList(){
        List<Vehicle> vehicles = vehicleRepository.findAll();

        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/search/{plate}")
    public ResponseEntity<Object> searchVehicle(@PathVariable(value="plate") String plate) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByPlate(plate);

        if(optionalVehicle.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optionalVehicle);

    }

}
