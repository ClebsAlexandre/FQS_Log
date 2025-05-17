package app;

import controller.OrderManage;
import controller.UserManage;
import controller.VehicleManage;
import repository.VehicleRepository;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vehicleRepository = new VehicleRepository();

        VehicleManage vehicleManage = new VehicleManage(vehicleRepository);
        OrderManage orderManage = new OrderManage(vehicleRepository);
        UserManage userManage = new UserManage();

        /*
         * userManage.customerRegister();
         * userManage.customerLogin();
         */

        /* orderManage.createOrder(); */

        /*
         * vehicleManage.createVehicle();
         * vehicleManage.deleteVehicle();
         * vehicleManage.vehiclesList();
         * vehicleManage.updateVehicle();
         */
    }
}
