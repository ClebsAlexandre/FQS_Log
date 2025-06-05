//package springboot.springboot.controller;
//
//import springboot.springboot.model.Order;
//import springboot.springboot.model.Vehicle;
//import springboot.springboot.repository.OrderRepository;
//import springboot.springboot.repository.VehicleRepository;
//
//import java.util.Scanner;
//
//public class OrderController {
//
//    private OrderRepository orderRepository = new OrderRepository();
//    private VehicleRepository vehicleRepository;
//    private Scanner scanner = new Scanner(System.in);
//
//    public OrderController(VehicleRepository vehicleRepository) {
//        this.vehicleRepository = vehicleRepository;
//    }
//
//    public void createOrder() {
//        System.out.println("=================================");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("|\t\t  Gerar Pedido  \t\t|");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("=================================");
//
//        System.out.println("Digite o CPF do destinatário:");
//        String cpf = scanner.nextLine();
//
//        if (cpf.length() != 11) {
//            System.out.println("CPF inválido. O CPF deve ter 11 dígitos.");
//            return;
//        }
//
//        System.out.println("=================================");
//        System.out.println("Digite o endereço:");
//        String address = scanner.nextLine();
//
//        System.out.println("=================================");
//        System.out.println("Selecione o status do pedido:");
//        System.out.println("1 - Sendo Processado");
//        System.out.println("2 - Em Transporte");
//        int status = scanner.nextInt();
//        scanner.nextLine();
//
//        Vehicle vehicle = null;
//
//        if (status == 2) {
//            System.out.println("Digite a placa do veículo:");
//            String plate = scanner.nextLine().trim().toUpperCase();
//
//            vehicle = vehicleRepository.searchByPlate(plate);
//
//            if (vehicle == null) {
//                System.out.println("Veículo não encontrado.");
//                return;
//            }
//
//            System.out.println("Localização: " + vehicle.getCurrentLocalization());
//        }
//        Order order = new Order(System.currentTimeMillis(), cpf, address, status, vehicle);
//
//        orderRepository.create(order);
//    }
//
//    public void searchByRecipientCPF() {
//        System.out.println("=================================");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("|\t\t  Pesquisar Pedido \t\t|");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("=================================");
//        System.out.println("Digite o CPF do destinatário:");
//        String recipientCPF = scanner.nextLine();
//
//        System.out.println("=================================");
//        Order order = orderRepository.searchByRecipientCPF(recipientCPF);
//        if (order != null) {
//            System.out.println("Pedido encontrado: \n" + order);
//        } else {
//            System.out.println("Pedido não encontrado.");
//        }
//    }
//
//    public void deleteOrder(){
//        System.out.println("=================================");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("|\t\t  Remover Pedido \t\t|");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("=================================");
//        System.out.println("Digite o ID do pedido:");
//        Long searchedOrder = scanner.nextLong();
//        scanner.nextLine();
//
//        Order existingOrder = orderRepository.searchById(searchedOrder);
//
//        System.out.println("=================================");
//
//        if (existingOrder == null){
//            System.out.println("Pedido não encontrado.");
//            return;
//        }
//
//        System.out.println(existingOrder);
//        System.out.println("Tem certeza que deseja remover-lo? (S / N)");
//        String option = scanner.nextLine().toUpperCase();
//
//        switch (option) {
//            case "S":
//                orderRepository.delete(searchedOrder);
//                break;
//            case "N":
//                return;
//            default:
//                System.out.println("Opção Inválida. Tente Novamente.");
//                break;
//        }
//
//    }
//
//    public void orderList(){
//        System.out.println("=================================");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("|\t\tLista de Pedidos\t\t|");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("=================================");
//
//        System.out.println(orderRepository.listAllOrders());
//    }
//
//}