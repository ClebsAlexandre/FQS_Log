package model;

import java.time.LocalDate;

public class Employee extends User {
    private String badgeNumber;
    private double salary;

    public Employee(Long id, String name, String login, String password, String email, LocalDate dateCreation, LocalDate dateUpdate, String badgeNumber, double salary) {
        super(id, name, login, password, email, dateCreation, dateUpdate);
        this.salary = salary;
        this.badgeNumber = badgeNumber;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\n{ Id: " + getId() + " | Matrícula: " + getBadgeNumber() + " | Nome: " + getName() + " | Login: " + getLogin() + " | Senha: " + getPassword() + " | Email: "
                + getEmail() + " | Data de Criação: " + getDateCreation() + " | Ultima Atualização: " + getDateUpdate() + " | Salário: " + getSalary() + " } ";
    }
}
