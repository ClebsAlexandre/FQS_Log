package model;

import java.time.LocalDate;

public class Customer extends User {

    private String cpf;

    public Customer(Long id, String name, String login, String password, String email, LocalDate dateCreation, LocalDate dateUpdate, String cpf) {
        super(id, name, login, password, email, dateCreation, dateUpdate);
        this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
