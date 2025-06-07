package springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CUSTOMER")
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User {

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    public Customer(String name, String login, String password, String email, String cpf) {
        super(name, login, password, email);
        this.cpf = cpf;
    }

    public Customer() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}