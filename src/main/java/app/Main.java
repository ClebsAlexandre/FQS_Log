package app;

import repository.VehicleRepository;
import service.CustomerService;
import service.OrderService;
import service.VehicleService;

public class Main {

    public static void main(String[] args) {
        VehicleRepository vehicleRepository = new VehicleRepository();

        VehicleService vehicleService = new VehicleService(vehicleRepository);
        OrderService orderService = new OrderService(vehicleRepository);
        CustomerService customerService = new CustomerService();

        vehicleService.createVehicle();
        orderService.createOrder();
    }

}
