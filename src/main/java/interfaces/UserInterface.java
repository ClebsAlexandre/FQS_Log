package interfaces;

import model.User;

import java.util.List;

public interface UserInterface {

    void create(User user);
    User searchByName(String name);
    User update(String name, String newName, String newLogin, String newEmail, String newPassword);
    void delete(String name);
    List<User> listAllUsers();

}
