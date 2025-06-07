package springboot.model;

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

    @Column(nullable = false, length = 11)
    private String recipientCPF;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(nullable = false, length = 60)
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    @JsonIgnoreProperties({"orders"})
    private Vehicle vehicle;

    public Order(){}

    public Order(String recipientCPF, String address, String status, Vehicle vehicle) {
        this.recipientCPF = recipientCPF;
        this.address = address;
        this.status = status;
        this.vehicle = vehicle;
    }


    public String getRecipientCPF() {
        return recipientCPF;
    }

    public void setRecipientCPF(String recipientCPF) {
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

}
