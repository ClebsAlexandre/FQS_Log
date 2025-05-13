package repository;

import interfaces.VehicleInterface;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements VehicleInterface {

    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void create(Vehicle vehicle) {
        vehicle.setPlate(vehicle.getPlate().trim().toUpperCase());
        vehicles.add(vehicle);
    }

    @Override
    public Vehicle search(String plate) {
        plate = plate.trim().toUpperCase();
        System.out.println("Buscando veículo com a placa: " + plate);
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlate().equals(plate)) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public Vehicle update(String plate, String newPlate, String newModel, String newCurrentLocalization) {
        Vehicle vehicle = search(plate);

        if (vehicle != null) {
            vehicle.setPlate(newPlate);
            vehicle.setModel(newModel);
            vehicle.setCurrentLocalization(newCurrentLocalization);
            return vehicle;
        }
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public void delete(String plate) {
        Vehicle vehicle = search(plate);
        if (vehicle != null) {
            vehicles.remove(vehicle);
        }
    }
}
