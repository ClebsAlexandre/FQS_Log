package repository;

import interfaces.UserInterface;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserInterface {

    private static List<User> usersList =  new ArrayList<>();


    @Override
    public void create(User user) {
        usersList.add(user);
    }

    @Override
    public User searchByName(String name) {
        User searchedUser = null;

        for (User user : usersList) {
            if (user.getName().equals(name)) {
                searchedUser = user;
                return searchedUser;
            }
        }
        return null;
    }


    public User update(String name, String newName, String newLogin, String newEmail, String newPassword) {

        User userToUpdate = searchByName(name);

        if (userToUpdate != null) {
            if (newName != null) {
                userToUpdate.setName(newName);
            }
            if (newLogin != null) {
                userToUpdate.setLogin(newLogin);
            }

            if (newEmail != null) {
                userToUpdate.setEmail(newEmail);
            }

            if (newPassword != null) {
                userToUpdate.setPassword(newPassword);
            }

            userToUpdate.setDateUpdate(LocalDate.now());
            return userToUpdate;
        }
        return null;
    }

    @Override
    public List<User> listAllUsers() {
        return usersList;
    }


    @Override
    public void delete(String name) {

        int position = -1;

        User userToDelete = searchByName(name);

        if (userToDelete != null) {
            position = usersList.indexOf(userToDelete);
        }

        if (position != -1) {
            usersList.remove(position);
        }
    }

}
