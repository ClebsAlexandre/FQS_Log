package controller;

import model.Customer;
import model.User;
import repository.UserRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserManage {

    private UserRepository userRepository = new UserRepository();
    private Scanner scanner = new Scanner(System.in);

    public void customerRegister () {

        System.out.println("======================");
        System.out.println("Registre-se");
        System.out.println("======================");
        System.out.println("Digite seu nome:");
        String name = scanner.nextLine();

        System.out.println("Digite seu CPF: (Apenas números)");
        String cpf = scanner.nextLine();

        if (cpf == null || cpf.length() != 11) {
            System.out.println("CPF inválido. \nTente novamente.");
            return;
        }

        System.out.println("Digite seu email:");
        String email = scanner.nextLine();
        if (email == null || !email.contains("@")) {
            System.out.println("Email inválido. \nTente novamente.");
            return;
        }

        System.out.println("Digite seu login:");
        String login = scanner.nextLine();


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
        System.out.println("Cadastro realizado com sucesso!");
    }

    public void customerLogin () {
        System.out.println("======================");
        System.out.println("Login");
        System.out.println("======================");
        System.out.println("Digite seu login:");
        String login = scanner.nextLine();

        System.out.println("Digite sua senha:");
        String password = scanner.nextLine();

        boolean found = false;

        for (User user : userRepository.getAllUsers()) {
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

    public List<User> listAllUsers() {
        System.out.println("======================");
        System.out.println("Lista de usuários");
        System.out.println("======================");

        List<User> users = userRepository.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        } else {
            for (User user : users) {
                System.out.println("ID: " + user.getId());
                System.out.println("Nome: " + user.getName());
                System.out.println("Login: " + user.getLogin());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Data de criação: " + user.getDateCreation());

                if (user instanceof Customer) {
                    System.out.println("CPF: " + ((Customer) user).getCpf());
                }
                System.out.println("----------------------");
            }
        }
        return users;
    }

    public void updateCustomer () {
        System.out.println("======================");
        System.out.println("Atualizar cadastro");
        System.out.println("======================");
        System.out.println("Digite seu nome:");
        name = scanner.nextLine();

        User user = userRepository.update(name, newName, newLogin, newEmail, newPassword);
        if (user != null) {
            System.out.println("Cadastro atualizado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void delete () {
        System.out.println("======================");
        System.out.println("Deletar cadastro");
        System.out.println("======================");
        System.out.println("Digite seu nome:");
        String name = scanner.nextLine();

        User userToDelete = userRepository.search(name);

        if (userToDelete != null) {

            System.out.println("Usuário Encontrando");
            System.out.println("ID: " + userToDelete.getId());
            System.out.println("Nome: " + userToDelete.getName());
            System.out.println("Login: " + userToDelete.getLogin());
            System.out.println("Email: " + userToDelete.getEmail());
            System.out.println("Data de criação: " + userToDelete.getDateCreation());

            if (userToDelete instanceof Customer) {
                System.out.println("CPF: " + ((Customer) userToDelete).getCpf());
            }

            userRepository.delete(name);
            System.out.println("Usuário deletado com sucesso!");
        }
        else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
