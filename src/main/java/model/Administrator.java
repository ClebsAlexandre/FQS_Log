package model;


import java.time.LocalDate;

public class Administrator extends User {

    public Administrator(Long id, String name, String login, String password, String email, LocalDate dateCreation, LocalDate dateUpdate, String cpf) {
        super(id, name, login, password, email, dateCreation, dateUpdate);
    }
}
