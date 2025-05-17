package model;

public class Vehicle {

    private String plate;
    private String model;
    private String currentLocalization;

    public Vehicle(String plate, String model, String currentLocalization) {
        this.plate = plate;
        this.model = model;
        this.currentLocalization = currentLocalization;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCurrentLocalization() {
        return currentLocalization;
    }

    public void setCurrentLocalization(String currentLocalization) {
        this.currentLocalization = currentLocalization;
    }

    @Override
    public String toString() {
        return "\nPlaca : " + getPlate() + ", \nModelo: " + getModel() + ", \nLocalização Atual: " + getCurrentLocalization() + "\n";
    }
}
