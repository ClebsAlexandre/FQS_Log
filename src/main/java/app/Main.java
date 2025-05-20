package app;

import java.util.Scanner;
import view.AdminView;
import view.CustomerView;
import view.EmployeeView;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AdminView adminView = new AdminView();
        CustomerView customerView = new CustomerView();
        EmployeeView  employeeView = new EmployeeView();

        int opt;

        do {
            System.out.println("=================================");
            System.out.println("|\t\t\t\t\t\t\t\t|");
            System.out.println("|\t\t\t FQS LOG \t\t\t|");
            System.out.println("|\t\t\t\t\t\t\t\t|");
            System.out.println("=================================");
            System.out.println("Entrar Como: ");
            System.out.println("1 - Cliente");
            System.out.println("2 - Funcionário");
            System.out.println("3 - Administração");
            System.out.println("0 - Fechar");
            System.out.println("Escolha: ");
            opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    customerView.costumerView();
                    break;
                case 2:
                    employeeView.employeeView();
                    break;
                case 3:
                    adminView.adminView();
                    break;
                case 0:
                    System.out.println("Fechando...");
                    break;
                default:
                    System.out.println("Opção Inválida. Tente Novamente.");
                    break;
            }
        } while (opt != 0);

    }
}
