//package springboot.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//
//import java.time.LocalDate;
//import java.util.UUID;
//
//@Entity
//@Table(name = "TB_EMPLOYEE")
//public class Employee extends User {
//    private String badgeNumber;
//    private double salary;
//
//    public Employee(String name, String login, String password, String email, String badgeNumber, double salary) {
//        super(name, login, password, email);
//        this.badgeNumber = badgeNumber;
//        this.salary = salary;
//    }
//
//    public Employee() {
//
//    }
//
//
//    public String getBadgeNumber() {
//        return badgeNumber;
//    }
//
//    public void setBadgeNumber(String badgeNumber) {
//        this.badgeNumber = badgeNumber;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    @Override
//    public String toString() {
//        return "\n{ Matrícula: " + getBadgeNumber() + " | Nome: " + getName() + " | Login: " + getLogin() + " | Senha: " + getPassword() + " | Email: " + getEmail() + " | Data de Criação: " + getDateCreation() + " | Ultima Atualização: " + getDateUpdate() + " | Salário: " + getSalary() + " } ";
//    }
//}
