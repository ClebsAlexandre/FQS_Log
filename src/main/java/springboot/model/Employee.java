package springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name = "TB_EMPLOYEE")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User {

    @Column(nullable = false, unique = true)
    private String badgeNumber;

    @Column(nullable = false)
    @DecimalMin(value = "0.01")
    private Double salary;

    public Employee(String name, String login, String password, String email, String badgeNumber, Double salary) {
        super(name, login, password, email);
        this.badgeNumber = badgeNumber;
        this.salary = salary;
    }

    public Employee(){}

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
