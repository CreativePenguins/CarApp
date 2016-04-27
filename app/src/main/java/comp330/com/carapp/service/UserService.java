package comp330.com.carapp.service;

import android.content.Context;

import java.util.ArrayList;

import comp330.com.carapp.dal.UserDAO;
import comp330.com.carapp.model.UserInterface;

/**
 * Service layer for user.
 */
public class UserService {
    private UserDAO userDAO;
    public  UserService(Context context) {
        userDAO = new UserDAO(context);
    }

    public ArrayList<UserInterface> getUserList() {
        try {
            return userDAO.getUserList();
        } catch (Exception e) {
            System.err.println("UserService: Threw an exception retrieving user list.");
            System.err.println(e.getMessage());
        } return null;
    }

    public void addUser(UserInterface newUser) {
        try {
            userDAO.addUser(newUser);
        } catch (Exception e) {
            System.err.println("UserService: Threw an exception adding to the user table");
            System.err.println(e.getMessage());
        }
    }
}
