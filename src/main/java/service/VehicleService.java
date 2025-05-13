package service;

import model.Vehicle;
import repository.VehicleRepository;

import java.util.Scanner;

public class VehicleService {

    private VehicleRepository vehicleRepository;
    private Scanner scanner = new Scanner(System.in);

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void createVehicle() {
        System.out.println("======================");
        System.out.println("Criar veículo");
        System.out.println("======================");

        System.out.println("Digite a placa do veículo:");
        String plate = scanner.nextLine();

        System.out.println("Digite o modelo do veículo:");
        String model = scanner.nextLine();

        System.out.println("Digite a localização atual do veículo:");
        String currentLocalization = scanner.nextLine();

        Vehicle vehicle = new Vehicle(plate, model, currentLocalization);

        vehicleRepository.create(vehicle);

        System.out.println("Veículo criado com sucesso!");
    }
}
