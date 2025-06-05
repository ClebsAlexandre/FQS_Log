package springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "TB_CUSTOMER")
public class Customer extends User {
    @Column(nullable = false, length = 11)
    private String cpf;

    public Customer(String name, String login, String password, String email, LocalDate dateCreation, LocalDate dateUpdate, String cpf) {
        super(name, login, password, email, dateCreation, dateUpdate);
        this.cpf = cpf;
    }

    public Customer() {
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\n{ CPF: " + getCpf() + " | Nome: " + getName() + " | Login: " + getLogin() + " | Senha: " + getPassword() + " | Email: "
                + getEmail() + " | Data de Criação: " + getDateCreation() + " | Ultima Atualização: " + getDateUpdate() + " } ";
    }
}
