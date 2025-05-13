package interfaces;

import model.Vehicle;

import java.util.List;

public interface VehicleInterface {

    void create(Vehicle vehicle);
    Vehicle search(String plate);
    Vehicle update(String plate, String newPlate, String newModel, String newCurrentLocalization);
    void delete(String plate);
    List<Vehicle> getAllVehicles();
}
