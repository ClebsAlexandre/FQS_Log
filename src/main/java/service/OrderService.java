package service;

import model.Vehicle;
import repository.OrderRepository;
import model.Order;
import repository.VehicleRepository;

import java.util.Scanner;

public class OrderService {

    private OrderRepository orderRepository = new OrderRepository();
    private VehicleRepository vehicleRepository;
    private Scanner scanner = new Scanner(System.in);

    public OrderService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void createOrder() {
        System.out.println("======================");
        System.out.println("Criar pedido");
        System.out.println("======================");

        System.out.println("Digite o CPF do destinatário:");
        String cpf = scanner.nextLine();

        if (cpf.length() != 11) {
            System.out.println("CPF inválido. O CPF deve ter 11 dígitos.");
            return;
        }

        System.out.println("Digite o endereço:");
        String address = scanner.nextLine();

        System.out.println("Selecione o status do pedido:");
        System.out.println("1 - Sendo Processado");
        System.out.println("2 - Em Transporte");
        System.out.println("3 - Entregue");
        int status = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a placa do veículo:");
        String plate = scanner.nextLine().trim().toUpperCase();

        Vehicle vehicle = vehicleRepository.search(plate);

        if (vehicle == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        System.out.println("Localização: " + vehicle.getCurrentLocalization());
    }


    public void consultOrderById() {
        System.out.println("======================");
        System.out.println("Consultar pedido");
        System.out.println("======================");
        System.out.println("Digite o ID do pedido:");
        Long orderId = scanner.nextLong();

        Order order = orderRepository.searchById(orderId);
        if (order != null) {
            System.out.println("Pedido encontrado: \n" + order);
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void consultOrderByRecipientCPF() {
        System.out.println("======================");
        System.out.println("Consultar pedido");
        System.out.println("======================");
        System.out.println("Digite o CPF do destinatário:");
        String recipientCPF = scanner.nextLine();

        Order order = orderRepository.searchByRecipientCPF(recipientCPF);
        if (order != null) {
            System.out.println("Pedido encontrado: \n" + order);
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }
}
