//package springboot.springboot.view;
//
//import springboot.springboot.controller.OrderController;
//import springboot.springboot.controller.UserController;
//import springboot.springboot.model.User;
//import springboot.springboot.repository.UserRepository;
//import springboot.springboot.repository.VehicleRepository;
//
//import java.util.Scanner;
//
//public class CustomerView {
//
//    public void costumerView() {
//        VehicleRepository vehicleRepository = new VehicleRepository();
//        OrderController orderController = new OrderController(vehicleRepository);
//        UserController userController = new UserController();
//        UserRepository userRepository = new UserRepository();
//        Scanner scanner = new Scanner(System.in);
//
//        int opt;
//
//        do {
//            System.out.println("O que deseja fazer?");
//            System.out.println("1 - Login");
//            System.out.println("2 - Registrar-se");
//            System.out.println("3 - Consultar Pedido");
//            System.out.println("0 - Sair");
//            System.out.println("Escolha: ");
//            opt = scanner.nextInt();
//            scanner.nextLine();
//
//            int customerChoose;
//            switch (opt) {
//                case 1:
//                    System.out.println("=================================");
//                    System.out.println("|\t\t\t\t\t\t\t\t|");
//                    System.out.println("|\t\t\t  Login \t\t\t|");
//                    System.out.println("|\t\t\t\t\t\t\t\t|");
//                    System.out.println("=================================");
//                    System.out.println("Digite seu login:");
//                    String login = scanner.nextLine();
//
//                    System.out.println("Digite sua senha:");
//                    String password = scanner.nextLine();
//
//                    boolean found = false;
//
//                    for (User user : userRepository.listAllUsers()) {
//                        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
//                            System.out.println("Login realizado com sucesso! \nBem-vindo, " + user.getName() + "!");
//                            found = true;
//
//
//                            do {
//                                System.out.println("1 - Atualizar Perfil");
//                                System.out.println("2 - Consultar Pedido");
//                                System.out.println("0 - Sair");
//                                customerChoose = scanner.nextInt();
//                                scanner.nextLine();
//
//                                switch (customerChoose) {
//                                    case 1:
//                                        userController.customerUpdate();
//                                        break;
//                                    case 2:
//                                        orderController.searchByRecipientCPF();
//                                        break;
//                                    case 0:
//                                        System.out.println("Saindo...");
//                                        break;
//                                }
//                            } while (customerChoose != 0);
//                            break;
//                        }
//                    }
//                    if (!found) {
//                        System.out.println("Login ou senha inválidos. \nTente novamente.");
//                    }
//                    break;
//                case 2:
//                    userController.customerRegister();
//                    break;
//                case 3:
//                    orderController.searchByRecipientCPF();
//                    break;
//                case 0:
//                    System.out.println("Saindo...");
//                    break;
//            }
//        } while (opt != 0);
//    }
//
//}
