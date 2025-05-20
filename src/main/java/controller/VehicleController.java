package controller;

import model.Vehicle;
import repository.VehicleRepository;

import java.util.Scanner;

public class VehicleController {

    private VehicleRepository vehicleRepository;
    private Scanner scanner = new Scanner(System.in);

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void createVehicle() {
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t  Criar Veículo \t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");

        System.out.println("Digite a placa do veículo:");
        String plate = scanner.nextLine().trim().toUpperCase();

        System.out.println("\n=================================");
        System.out.println("Digite o modelo do veículo:");
        String model = scanner.nextLine().toUpperCase();

        System.out.println("\n=================================");
        System.out.println("Digite a localização atual do veículo:");
        String currentLocalization = scanner.nextLine();

        System.out.println("\n=================================");
        Vehicle vehicle = new Vehicle(plate, model, currentLocalization);

        vehicleRepository.create(vehicle);

        System.out.println("Veículo: {" + vehicle + "} criado com sucesso!");
    }

    public void updateVehicle() {

        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\tAtualizar Veículo\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");

        String searchedVehicle, newPlate, newModel, newLocalization;

        System.out.println("Digite a placa do veículo que deseja alterar: ");
        searchedVehicle = scanner.nextLine().trim().toUpperCase();

        Vehicle existingVehicle = vehicleRepository.searchByPlate(searchedVehicle);
        if (existingVehicle == null) {
            System.out.println("Veículo não encontrado. Tente novamente.");
            return;
        }

        System.out.println("* Deixe em branco os campos que não deseja alterar *");

        System.out.println("Insira a nova placa: ");
        newPlate = scanner.nextLine().trim().toUpperCase();
        if (newPlate.isEmpty()) {
            newPlate = null;
        }

        System.out.println("Insira o novo modelo: ");
        newModel = scanner.nextLine().trim().toUpperCase();
        if (newModel.isEmpty()) {
            newModel = null;
        }

        System.out.println("Insira a nova localização: ");
        newLocalization = scanner.nextLine();
        if (newLocalization.isEmpty()) {
            newLocalization = null;
        }

        vehicleRepository.update(searchedVehicle, newPlate, newModel, newLocalization);
    }

    public void deleteVehicle() {
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t  Remover Veículo \t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite a placa do veículo que deseja remover: ");
        String searchedVehicle = scanner.nextLine().trim().toUpperCase();

        Vehicle existingVehicle = vehicleRepository.searchByPlate(searchedVehicle);
        if (existingVehicle == null) {
            System.out.println("Veículo não encontrado. Tente novamente.");
            return;
        }

        System.out.println(existingVehicle);
        System.out.println("Tem certeza que deseja remover-lo? (S / N)");
        String option = scanner.nextLine().toUpperCase();

        switch (option) {
            case "S":
                vehicleRepository.delete(searchedVehicle);
                break;
            case "N":
                return;
            default:
                System.out.println("Opção Inválida. Tente Novamente.");
                break;
        }

    }

    public void vehiclesList(){
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\tLista de Veículos\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");

        System.out.println(vehicleRepository.listAllVehicles());
    }

}
