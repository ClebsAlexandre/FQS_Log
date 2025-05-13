package repository;

import interfaces.UserInterface;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserInterface {

    private List<User> users = new ArrayList<>();

    @Override
    public void create(User user) {
        users.add(user);
    }

    @Override
    public User search(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }


    public User update(String name, String newName, String newLogin, String newEmail, String newPassword) {
        User  user = search(name);

        if(user != null) {
            user.setName(newName);
            user.setLogin(newLogin);
            user.setEmail(newEmail);
            user.setPassword(newPassword);
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }


    @Override
    public void delete(String name) {

        User user = search(name);
        if (user != null) {
            users.remove(user);
        }
    }

}
