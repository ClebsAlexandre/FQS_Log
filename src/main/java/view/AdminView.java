package view;

import controller.OrderController;
import controller.UserController;
import controller.VehicleController;
import repository.VehicleRepository;

import java.util.Scanner;

public class AdminView {

    public void adminView() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        UserController userController = new UserController();
        VehicleController vehicleController = new VehicleController(vehicleRepository);
        OrderController orderController = new OrderController(vehicleRepository);

        int opt = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t  Acesso Administrativo \t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");

        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("=================================");
        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        if (!login.equals("admin") || !senha.equals("admin#123")) {
            System.out.println("Login ou senha inválidos. Tente Novamente.");
            return;
        } else {
            do {
                System.out.println("1 - Gerenciar Funcionários");
                System.out.println("2 - Gerenciar Pedidos");
                System.out.println("3 - Gerenciar Clientes");
                System.out.println("4 - Gerenciar Veículos");
                System.out.println("0 - Voltar");
                System.out.println("Escolha:");
                opt = scanner.nextInt();
                int funcChoose;

                switch (opt) {
                    case 1:
                        System.out.println("=================================");
                        System.out.println("|\t\t\t\t\t\t\t\t|");
                        System.out.println("|\t  Gerenciar Funcionários \t|");
                        System.out.println("|\t\t\t\t\t\t\t\t|");
                        System.out.println("=================================");
                        System.out.println("1 - Adicionar");
                        System.out.println("2 - Remover");
                        System.out.println("3 - Listar Todos");
                        System.out.println("4 - Pesquisar");
                        System.out.println("0 - Voltar");
                        System.out.println("Escollha: ");
                        funcChoose = scanner.nextInt();

                        switch (funcChoose) {
                            case 1:
                                userController.employeeCreate();
                                break;
                            case 2:
                                userController.employeeDelete();
                                break;
                            case 3:
                                userController.listAllEmployees();
                                break;
                            case 4:
                                userController.searchEmployee();
                                break;
                            case 0:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("Opção Inválida. Tente Novamente.");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("=================================");
                        System.out.println("|\t\t\t\t\t\t\t\t|");
                        System.out.println("|\t\tGerenciar Pedidos\t\t|");
                        System.out.println("|\t\t\t\t\t\t\t\t|");
                        System.out.println("=================================");
                        System.out.println("1 - Adicionar");
                        System.out.println("2 - Remover");
                        System.out.println("3 - Listar Todos");
                        System.out.println("4 - Pesquisar");
                        System.out.println("0 - Voltar");
                        System.out.println("Escollha: ");
                        funcChoose = scanner.nextInt();
                        switch (funcChoose) {
                            case 1:
                                orderController.createOrder();
                                break;
                            case 2:
                                orderController.deleteOrder();
                                break;
                            case 3:
                                orderController.orderList();
                                break;
                            case 4:
                                orderController.searchByRecipientCPF();
                                break;
                            case 0:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("Opção Inválida. Tente Novamente.");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("=================================");
                        System.out.println("|\t\t\t\t\t\t\t\t|");
                        System.out.println("|\t\tGerenciar Clientes\t\t|");
                        System.out.println("|\t\t\t\t\t\t\t\t|");
                        System.out.println("=================================");
                        System.out.println("1 - Remover");
                        System.out.println("2 - Listar Todos");
                        System.out.println("3 - Pesquisar");
                        System.out.println("0 - Voltar");
                        System.out.println("Escollha: ");
                        funcChoose = scanner.nextInt();
                        switch (funcChoose) {
                            case 1:
                                userController.customerDelete();
                                break;
                            case 2:
                                userController.listAllCustomer();
                                break;
                            case 3:
                                userController.searchCustomer();
                                break;
                            case 0:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("Opção Inválida. Tente Novamente.");
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("=================================");
                        System.out.println("|\t\t\t\t\t\t\t\t|");
                        System.out.println("|\t\tGerenciar Veículos\t\t|");
                        System.out.println("|\t\t\t\t\t\t\t\t|");
                        System.out.println("=================================");
                        System.out.println("1 - Adicionar");
                        System.out.println("2 - Remover");
                        System.out.println("3 - Listar Todos");
                        System.out.println("4 - Atualizar");
                        System.out.println("0 - Sair");
                        System.out.println("Escollha: ");
                        funcChoose = scanner.nextInt();
                        switch (funcChoose) {
                            case 1:
                                vehicleController.createVehicle();
                                break;
                            case 2:
                                vehicleController.deleteVehicle();
                                break;
                            case 3:
                                vehicleController.vehiclesList();
                                break;
                            case 4:
                                vehicleController.updateVehicle();
                                break;
                            case 0:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("Opção Inválida. Tente Novamente.");
                                break;
                        }
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção Inválida. Tente Novamente.");
                        break;
                }
            } while (opt != 0);
        }


    }
}


