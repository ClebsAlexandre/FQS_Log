package model;

import model.Vehicle;

public class Order {

    private Long id;
    private String recipientCPF;
    private String status;
    private String address;
    private Vehicle vehicle;

    public Order(Long id, String recipientCPF, String address, String status, Vehicle vehicle) {
        this.id = id;
        this.recipientCPF = recipientCPF;
        this.address = address;
        this.status = status;
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
