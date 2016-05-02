package comp330.com.carapp.service;

import android.content.Context;

import java.util.ArrayList;

import comp330.com.carapp.dal.UserDAO;
import comp330.com.carapp.model.UserInterface;

/**
 * Service layer for the user - middle layer between DAO and Android view
 */
public class UserService {

    private UserDAO userDAO;

    public  UserService(Context context) {
        userDAO = new UserDAO(context);
    }

    /**
     * Gets all the user entries from the database.
     * @return an ArrayList of user objects
     */
    public ArrayList<UserInterface> getUserList() {
        try {
            return userDAO.getUserList();
        } catch (Exception e) {
            System.err.println("UserService: Threw an exception retrieving user list.");
            System.err.println(e.getMessage());
        } return null;
    }

    /**
     * Adds a user to the user table.
     * @param newUser to be added to user table
     */
    public void addUser(UserInterface newUser) {
        try {
            userDAO.addUser(newUser);
        } catch (Exception e) {
            System.err.println("UserService: Threw an exception adding to the user table");
            System.err.println(e.getMessage());
        }
    }
}
