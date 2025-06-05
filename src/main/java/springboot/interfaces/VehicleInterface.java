package springboot.interfaces;

import springboot.model.Vehicle;

import java.util.List;

public interface VehicleInterface {

    void create(Vehicle vehicle);
    Vehicle searchByPlate(String plate);
    Vehicle update(String plate, String newPlate, String newModel, String newCurrentLocalization);
    void delete(String plate);
    List<Vehicle> listAllVehicles();
}
