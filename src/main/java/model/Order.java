package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Table(name = "TB_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 11)
    private String recipientCPF;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(nullable = false, length = 60)
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"orders"})
    private Vehicle vehicle;

    public Order(){}

    public Order(UUID id, String recipientCPF, String address, String status, Vehicle vehicle) {
        this.id = id;
        this.recipientCPF = recipientCPF;
        this.address = address;
        this.status = status;
        this.vehicle = vehicle;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipientCPF;
    }

    public void setRecipient(String recipientCPF) {
        this.recipientCPF = recipientCPF;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString(){
        return "{ Id: " + getId()+  " | Destinatário: " + getRecipient() +  " | Status: " + getStatus()+ " | Endereço: " + getAddress() +  " | Veículo: " + getVehicle() + " } ";
    }
}
