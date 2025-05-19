package controller;

import model.Customer;
import model.User;
import repository.UserRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class UserController {

    private UserRepository userRepository = new UserRepository();
    private Scanner scanner = new Scanner(System.in);

    public void customerRegister () {

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
                System.currentTimeMillis(),
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

    public void customerLogin () {
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t\t  Login \t\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite seu login:");
        String login = scanner.nextLine();

        System.out.println("Digite sua senha:");
        String password = scanner.nextLine();

        boolean found = false;

        for (User user : userRepository.listAllUsers()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Login realizado com sucesso! \nBem-vindo, " + user.getName() + "!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Login ou senha inválidos. \nTente novamente.");
        }
    }

    public void listAllUsers() {
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\tLista de Usuários\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");

        System.out.println(userRepository.listAllUsers());

    }

    public void userUpdate() {

        String searchedUser, newName, newLogin, newEmail, newPassword;

        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\tAtualizar Usuário\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite seu nome:");
        searchedUser = scanner.nextLine();

        User existingUser = userRepository.searchByName(searchedUser);

        if (existingUser == null) {
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

        System.out.println("Digite a nova senha: ");
        newPassword = scanner.nextLine();
        if (newPassword.isEmpty()) {
            newPassword = null;
        }

        userRepository.update(searchedUser, newName, newLogin, newEmail, newPassword);

    }

    public void userDelete() {
        System.out.println("=================================");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t  Remover Usuário \t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("=================================");
        System.out.println("Digite o nome do usuário a ser removido: ");
        String searchedUser = scanner.nextLine();

        User existingUser = userRepository.searchByName(searchedUser);

        if (existingUser == null) {

            System.out.println("Usuário não encontrado");
            return;
        }

        System.out.println("Usuario Encontrado:");
        System.out.println(existingUser);
        System.out.println("Tem certeza que deseja remover-lo? (SIM / NÃO)");
        String option = scanner.nextLine().toUpperCase();

        switch (option) {
            case "SIM":
            case "S":
                userRepository.delete(searchedUser);
                break;
            case "NÃO":
            case "NAO":
            case "N":
                return;
            default:
                System.out.println("Opção Inválida. Tente Novamente.");
                break;
        }


    }
}
