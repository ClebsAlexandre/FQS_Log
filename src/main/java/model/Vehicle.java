package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 10, unique = true)
    private String plate;

    @Column(nullable = false, length = 20)
    private String model;

    @Column(nullable = false, length = 70)
    private String currentLocalization;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnoreProperties({"vehicle"})
    private List<Order> orders = new ArrayList<>();

    public Vehicle() {}

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
        return "\n{ Placa : " + getPlate() + " | Modelo: " + getModel() + " | Localização Atual: " + getCurrentLocalization() + " } ";
    }
}
