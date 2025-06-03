package controller;

import model.Customer;
import model.Employee;
import model.User;
import repository.UserRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class UserController {

    private UserRepository userRepository = new UserRepository();
    private Scanner scanner = new Scanner(System.in);

    public void employeeCreate() {

        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t  Adicionar Funcionário \t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");

        System.out.println("Insira o nome: ");
        String name = scanner.nextLine();

        System.out.println("=================================");
        System.out.println("Insira o login: ");
        String login = scanner.nextLine();

        System.out.println("=================================");
        System.out.println("Insira a senha: ");
        String password = scanner.nextLine();
        if (password == null || password.length() < 6) {
            System.out.println("Mínimo 6 caracteres. \nTente novamente.");
            return;
        }

        System.out.println("Confirme sua senha:");
        String passwordConfirmation = scanner.nextLine();

        if (passwordConfirmation == null || !passwordConfirmation.equals(password)) {
            System.out.println("Senhas diferentes. \nTente novamente.");
            return;
        }

        System.out.println("=================================");
        System.out.println("Insira o email: ");
        String email = scanner.nextLine();
        if (email == null || !email.contains("@")) {
            System.out.println("=================================");
            System.out.println("Email inválido. \nTente novamente.");
            return;
        }

        System.out.println("Insira o salário: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Insira a matrícula: ");
        String badgeNumber = scanner.nextLine();

        Employee employee = new Employee(
                name,
                login,
                password,
                email,
                LocalDate.now(),
                LocalDate.now(),
                badgeNumber,
                salary);

        userRepository.create(employee);

    }

    public void customerRegister() {

        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\tRegistre-se\t\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");

        System.out.println("Digite seu nome:");
        String name = scanner.nextLine();

        System.out.println("=================================");
        System.out.println("Digite seu CPF: (Apenas números)");
        String cpf = scanner.nextLine();

        if (cpf == null || cpf.length() != 11) {
            System.out.println("=================================");
            System.out.println("CPF inválido. \nTente novamente.");
            return;
        }

        System.out.println("=================================");
        System.out.println("Digite seu email:");
        String email = scanner.nextLine();
        if (email == null || !email.contains("@")) {
            System.out.println("=================================");
            System.out.println("Email inválido. \nTente novamente.");
            return;
        }

        System.out.println("=================================");
        System.out.println("Digite seu login:");
        String login = scanner.nextLine();

        System.out.println("=================================");
        System.out.println("Digite sua senha:");
        String password = scanner.nextLine();
        if (password == null || password.length() < 6) {
            System.out.println("Mínimo 6 caracteres. \nTente novamente.");
            return;
        }

        System.out.println("Confirme sua senha:");
        String passwordConfirmation = scanner.nextLine();

        if (passwordConfirmation == null || !passwordConfirmation.equals(password)) {
            System.out.println("Senhas diferentes. \nTente novamente.");
            return;
        }

        Customer customer = new Customer(
                name,
                login,
                password,
                email,
                LocalDate.now(),
                LocalDate.now(),
                cpf
        );

        userRepository.create(customer);
        System.out.println("=================================");
        System.out.println("Cadastro realizado com sucesso!");
    }

    public void listAllEmployees() {
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\tLista Funcionários\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");

        for (User user : userRepository.listAllUsers()) {
            if (user instanceof Employee) {
                System.out.println(user);
            }
        }
    }

    public void listAllCustomer() {
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\tLista de Clientes\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");

        for (User user : userRepository.listAllUsers()) {
            if (user instanceof Customer) {
                System.out.println(user);
            }
        }
    }

    public void searchCustomer() {

        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\tPesquisar\t\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite o nome do Cliente: ");
        String name = scanner.nextLine();

        User existingUser = userRepository.searchByName(name);
        if (existingUser == null || !(existingUser instanceof Customer)) {
            System.out.println("Usuário não encontrado. Tente novamente.");
            return;
        }
        System.out.println("Funcionário encontrado: ");
        System.out.println(existingUser);


    }

    public void searchEmployee() {

        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\tPesquisar\t\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite o nome do Funcionário: ");
        String name = scanner.nextLine();

        User existingUser = userRepository.searchByName(name);
        if (existingUser == null || !(existingUser instanceof Employee)) {
            System.out.println("Usuário não encontrado. Tente novamente.");
            return;
        }
        System.out.println("Funcionário encontrado: ");
        System.out.println(existingUser);


    }

    public void employeeUpdate() {

        String searchedUser, newName, newLogin, newEmail, newPassword;

        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\tAtualizar Usuário\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite seu nome:");
        searchedUser = scanner.nextLine();

        User existingUser = userRepository.searchByName(searchedUser);

        if (existingUser == null || !(existingUser instanceof Employee)) {
            System.out.println("Usuário não encontrado. Tente novamente.");
            return;
        }
        System.out.println("* Deixe em branco os campos que não deseja alterar *");

        System.out.println("Digite o novo nome: ");
        newName = scanner.nextLine();
        if (newName.isEmpty()) {
            newName = null;
        }

        System.out.println("Digite o novo login: ");
        newLogin = scanner.nextLine();
        if (newLogin.isEmpty()) {
            newLogin = null;
        }

        System.out.println("Digite o novo email: ");
        newEmail = scanner.nextLine();
        if (newEmail.isEmpty()) {
            newEmail = null;
        }

        if (newEmail == null || !newEmail.contains("@")) {
            System.out.println("=================================");
            System.out.println("Email inválido. \nTente novamente.");
            return;
        }

        System.out.println("Digite a nova senha: ");
        newPassword = scanner.nextLine();
        if (newPassword.isEmpty()) {
            newPassword = null;
        }

        if (newPassword == null || newPassword.length() < 6) {
            System.out.println("Mínimo 6 caracteres. \nTente novamente.");
            return;
        }

        if (newPassword != null) {
            System.out.println("Confirme a senha: ");
            String confirmPassword = scanner.nextLine();

            if (!confirmPassword.equals(newPassword)) {
                System.out.println("Senhas diferentes. \nTente novamente.");
                return;
            }
        }

        userRepository.update(searchedUser, newName, newLogin, newEmail, newPassword);
        System.out.println("=================================");
        System.out.println("Usuário Atualizado com Sucesso!");


    }

    public void customerUpdate() {

        String searchedUser, newName, newLogin, newEmail, newPassword;

        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\tAtualizar Usuário\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite seu nome:");
        searchedUser = scanner.nextLine();

        User existingUser = userRepository.searchByName(searchedUser);

        if (existingUser == null || !(existingUser instanceof Customer)) {
            System.out.println("Usuário não encontrado. Tente novamente.");
            return;
        }
        System.out.println("* Deixe em branco os campos que não deseja alterar *");

        System.out.println("Digite o novo nome: ");
        newName = scanner.nextLine();
        if (newName.isEmpty()) {
            newName = null;
        }

        System.out.println("Digite o novo login: ");
        newLogin = scanner.nextLine();
        if (newLogin.isEmpty()) {
            newLogin = null;
        }

        System.out.println("Digite o novo email: ");
        newEmail = scanner.nextLine();
        if (newEmail.isEmpty()) {
            newEmail = null;
        }

        if (newEmail == null || !newEmail.contains("@")) {
            System.out.println("=================================");
            System.out.println("Email inválido. \nTente novamente.");
            return;
        }

        System.out.println("Digite a nova senha: ");
        newPassword = scanner.nextLine();
        if (newPassword.isEmpty()) {
            newPassword = null;
        }

        if (newPassword == null || newPassword.length() < 6) {
            System.out.println("Mínimo 6 caracteres. \nTente novamente.");
            return;
        }

        if (newPassword != null) {
            System.out.println("Confirme a senha: ");
            String confirmPassword = scanner.nextLine();

            if (!confirmPassword.equals(newPassword)) {
                System.out.println("Senhas diferentes. \nTente novamente.");
                return;
            }
        }

        userRepository.update(searchedUser, newName, newLogin, newEmail, newPassword);
        System.out.println("=================================");
        System.out.println("Usuário Atualizado com Sucesso!");

    }

    public void employeeDelete() {
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t  Remover Usuário \t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite o nome do usuário a ser removido: ");
        String searchedUser = scanner.nextLine();

        User existingUser = userRepository.searchByName(searchedUser);

        if (existingUser == null || !(existingUser instanceof Employee)) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Usuario Encontrado:");
        System.out.println(existingUser);
        System.out.println("Tem certeza que deseja remover-lo? (S / N)");
        String option = scanner.nextLine().toUpperCase();

        switch (option) {
            case "S":
                userRepository.delete(searchedUser);
                System.out.println("=================================");
                System.out.println("Funcionario Removido com Sucesso!");
                break;
            case "N":
                return;
            default:
                System.out.println("Opção Inválida. Tente Novamente.");
                break;
        }

    }

    public void customerDelete() {
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t  Remover Usuário \t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite o nome do usuário a ser removido: ");
        String searchedUser = scanner.nextLine();

        User existingUser = userRepository.searchByName(searchedUser);

        if (existingUser == null || !(existingUser instanceof Customer)) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Usuario Encontrado:");
        System.out.println(existingUser);
        System.out.println("Tem certeza que deseja remover-lo? (S / N)");
        String option = scanner.nextLine().toUpperCase();

        switch (option) {
            case "S":
                userRepository.delete(searchedUser);
                System.out.println("=================================");
                System.out.println("Cliente Removido com Sucesso!");
                break;
            case "N":
                return;
            default:
                System.out.println("Opção Inválida. Tente Novamente.");
                break;
        }

    }
}
