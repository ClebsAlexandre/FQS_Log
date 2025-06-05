//package springboot.springboot.view;
//
//import springboot.springboot.controller.OrderController;
//import springboot.springboot.controller.UserController;
//import springboot.springboot.controller.VehicleController;
//import springboot.springboot.model.User;
//import springboot.springboot.repository.UserRepository;
//import springboot.springboot.repository.VehicleRepository;
//
//import java.util.Scanner;
//
//public class EmployeeView {
//    public void employeeView() {
//        VehicleRepository  vehicleRepository = new VehicleRepository();
//        VehicleController vehicleController = new VehicleController(vehicleRepository);
//        OrderController orderController = new OrderController(vehicleRepository);
//        UserController userController = new UserController();
//        UserRepository userRepository = new UserRepository();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("=================================");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("|\t\t\t  Login \t\t\t|");
//        System.out.println("|\t\t\t\t\t\t\t\t|");
//        System.out.println("=================================");
//        System.out.println("Digite seu login:");
//        String login = scanner.nextLine();
//
//        System.out.println("Digite sua senha:");
//        String password = scanner.nextLine();
//
//        boolean found = false;
//
//        for (User user : userRepository.listAllUsers()) {
//            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
//                System.out.println("Login realizado com sucesso! \nBem-vindo, " + user.getName() + "!");
//                found = true;
//
//                int opt;
//                int customerChoose;
//                do {
//                    System.out.println("1 - Gerenciar Pedidos");
//                    System.out.println("2 - Gerenciar Clientes");
//                    System.out.println("3 - Gerenciar Veículos");
//                    System.out.println("0 - Voltar");
//                    System.out.println("Escolha:");
//                    opt = scanner.nextInt();
//                    int funcChoose;
//
//                    switch (opt) {
//                        case 1:
//                            System.out.println("=================================");
//                            System.out.println("|\t\t\t\t\t\t\t\t|");
//                            System.out.println("|\t\tGerenciar Pedidos\t\t|");
//                            System.out.println("|\t\t\t\t\t\t\t\t|");
//                            System.out.println("=================================");
//                            System.out.println("1 - Adicionar");
//                            System.out.println("2 - Remover");
//                            System.out.println("3 - Listar Todos");
//                            System.out.println("4 - Pesquisar");
//                            System.out.println("0 - Voltar");
//                            System.out.println("Escollha: ");
//                            funcChoose = scanner.nextInt();
//                            switch (funcChoose) {
//                                case 1:
//                                    orderController.createOrder();
//                                    break;
//                                case 2:
//                                    orderController.deleteOrder();
//                                    break;
//                                case 3:
//                                    orderController.orderList();
//                                    break;
//                                case 4:
//                                    orderController.searchByRecipientCPF();
//                                    break;
//                                case 0:
//                                    System.out.println("Voltando...");
//                                    break;
//                                default:
//                                    System.out.println("Opção Inválida. Tente Novamente.");
//                                    break;
//                            }
//                            break;
//                        case 2:
//                            System.out.println("=================================");
//                            System.out.println("|\t\t\t\t\t\t\t\t|");
//                            System.out.println("|\t\tGerenciar Clientes\t\t|");
//                            System.out.println("|\t\t\t\t\t\t\t\t|");
//                            System.out.println("=================================");
//                            System.out.println("1 - Remover");
//                            System.out.println("2 - Listar Todos");
//                            System.out.println("3 - Pesquisar");
//                            System.out.println("0 - Voltar");
//                            System.out.println("Escollha: ");
//                            funcChoose = scanner.nextInt();
//                            switch (funcChoose) {
//                                case 1:
//                                    userController.customerDelete();
//                                    break;
//                                case 2:
//                                    userController.listAllCustomer();
//                                    break;
//                                case 3:
//                                    userController.searchCustomer();
//                                    break;
//                                case 0:
//                                    System.out.println("Voltando...");
//                                    break;
//                                default:
//                                    System.out.println("Opção Inválida. Tente Novamente.");
//                                    break;
//                            }
//                            break;
//                        case 3:
//                            System.out.println("=================================");
//                            System.out.println("|\t\t\t\t\t\t\t\t|");
//                            System.out.println("|\t\tGerenciar Veículos\t\t|");
//                            System.out.println("|\t\t\t\t\t\t\t\t|");
//                            System.out.println("=================================");
//                            System.out.println("1 - Adicionar");
//                            System.out.println("2 - Remover");
//                            System.out.println("3 - Listar Todos");
//                            System.out.println("4 - Atualizar");
//                            System.out.println("0 - Sair");
//                            System.out.println("Escollha: ");
//                            funcChoose = scanner.nextInt();
//                            switch (funcChoose) {
//                                case 1:
//                                    vehicleController.createVehicle();
//                                    break;
//                                case 2:
//                                    vehicleController.deleteVehicle();
//                                    break;
//                                case 3:
//                                    vehicleController.vehiclesList();
//                                    break;
//                                case 4:
//                                    vehicleController.updateVehicle();
//                                    break;
//                                case 0:
//                                    System.out.println("Voltando...");
//                                    break;
//                                default:
//                                    System.out.println("Opção Inválida. Tente Novamente.");
//                                    break;
//                            }
//                            break;
//                        case 0:
//                            System.out.println("Saindo...");
//                            break;
//                        default:
//                            System.out.println("Opção Inválida. Tente Novamente.");
//                            break;
//                    }
//                } while (opt != 0);
//            }
//        }
//        if (!found) {
//            System.out.println("Login ou senha inválidos. \nTente novamente.");
//        }
//    }
//}
