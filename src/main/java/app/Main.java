package app;

import controller.OrderController;
import controller.UserController;
import controller.VehicleController;
import repository.VehicleRepository;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vehicleRepository = new VehicleRepository();

        VehicleController vehicleController = new VehicleController(vehicleRepository);
        OrderController orderController = new OrderController(vehicleRepository);
        UserController userController = new UserController();


        //userController.customerRegister();
        //userController.customerLogin();
        //userController.userUpdate();
        //userController.userDelete();
        // userController.listAllUsers();


        /* orderController.createOrder(); */


        //vehicleController.createVehicle();
        //vehicleController.deleteVehicle();
        //vehicleController.updateVehicle();
        //vehicleController.vehiclesList();
    }
}
