package model;

import java.time.LocalDate;

public class Employee extends User {
    private double salary;

    public Employee(Long id, String name, String login, String password, String email, LocalDate dateCreation, LocalDate dateUpdate, String cpf) {
        super(id, name, login, password, email, dateCreation, dateUpdate);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
