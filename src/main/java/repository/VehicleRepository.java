package repository;

import interfaces.VehicleInterface;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements VehicleInterface {

    private List<Vehicle> vehiclesList;

    public VehicleRepository() {
        vehiclesList = new ArrayList<Vehicle>();
    }

    @Override
    public void create(Vehicle vehicle) {
        vehiclesList.add(vehicle);
    }

    @Override
    public Vehicle searchByPlate(String plate) {
        Vehicle searchedVehicle = null;

        for (Vehicle vehicle : vehiclesList) {
            if (vehicle.getPlate().equals(plate)) {
                searchedVehicle = vehicle;
                return searchedVehicle;
            }
        }
        return null;

    }

    @Override
    public Vehicle update(String plate, String newPlate, String newModel, String newCurrentLocalization) {

        Vehicle vehicleToUpdate = searchByPlate(plate);

        if (vehicleToUpdate != null) {
            if (newPlate != null) {
                vehicleToUpdate.setPlate(newPlate);
            }

            if (newModel != null) {
                vehicleToUpdate.setModel(newModel);
            }

            if (newCurrentLocalization != null) {
                vehicleToUpdate.setCurrentLocalization(newCurrentLocalization);
            }

            return vehicleToUpdate;
        } 
        
        return null;
    }

    @Override
    public List<Vehicle> listAllVehicles() {
        return vehiclesList;
    }

    @Override
    public void delete(String plate) {
        int position = -1;

        Vehicle vehicle = searchByPlate(plate);
        if (vehicle != null) {
            position = vehiclesList.indexOf(vehicle);
        }

        if (position != -1) {
            vehiclesList.remove(position);
        }

    }
}
