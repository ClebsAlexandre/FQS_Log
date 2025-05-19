package model;

import java.time.LocalDate;

public class Employee extends User {
    private long badgeNumber;
    private double salary;

    public Employee(Long id, String name, String login, String password, String email, LocalDate dateCreation, LocalDate dateUpdate, long badgeNumber, double salary) {
        super(id, name, login, password, email, dateCreation, dateUpdate);
        this.salary = salary;
        this.badgeNumber = badgeNumber;
    }

    public long getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(long badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
