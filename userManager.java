import java.io.*;
import java.util.ArrayList;

/**
 * The UserManager class is responsible for managing user information.
 */
public class UserManager {
    private static UserManager userManager;
    private ArrayList<User> usersList;

    private UserManager() {
        this.usersList = new ArrayList<>();
    }

    /**
     * Gets the instance of the UserManager using the Singleton pattern.
     *
     * @return The UserManager instance.
     */
    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    /**
     * Adds a new user to the user list.
     *
     * @param firstName   The first name of the user.
     * @param lastName    The last name of the user.
     * @param userName    The user's username.
     * @param password    The user's password.
     * @param email       The user's email address.
     * @param phoneNumber The user's phone number.
     * @param birthdate   The user's birthdate.
     * @param address     The user's address.
     * @param type        The user's type (e.g., "admin" or "user").
     * @return true if the user is added successfully, false otherwise.
     */
    public boolean addUser(String firstName, String lastName, String userName, String password, String email, String phoneNumber, String birthdate, String address, String type) {
        for (User user : usersList) {
            if (user.getUserName().equals(userName)) {
                return false; // User with the same username already exists.
            }
        }

        User user = new User(userName, password, firstName, lastName, email, phoneNumber, birthdate, address);
        user.setUserRole(type);
        usersList.add(user);
        return true;
    }

    /**
     * Removes a user from the user list.
     *
     * @param userName The username of the user to be removed.
     * @param password The user's password for authentication.
     * @return true if the user is removed successfully, false otherwise.
     */
    public boolean removeUser(String userName, String password) {
        User userToRemove = null;
        for (User user : usersList) {
            if (user.getUserName().equals(userName) && user.checkPassword(password)) {
                userToRemove = user;
                break;
            }
        }

        if (userToRemove != null) {
            usersList.remove(userToRemove);
            return true;
        }

        return false;
    }

    /**
     * Retrieves a user by their username.
     *
     * @param userName The username of the user.
     * @return The User object if found, or null if not found.
     */
    public User getUser(String userName) {
        for (User user : usersList) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Retrieves the list of all users.
     *
     * @return An ArrayList of User objects representing all users.
     */
    public ArrayList<User> getUserList() {
        return usersList;
    }

    /**
     * Checks if a user with a given username exists in the user list.
     *
     * @param userName The username to check.
     * @return true if the user exists, false otherwise.
     */
    public boolean hasUser(String userName) {
        for (User user : usersList) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Edits the password of a user.
     *
     * @param userName The username of the user.
     * @param password The new password to set.
     * @return true if the password is updated successfully, false otherwise.
     */
    public boolean editUserPassword(String userName, String password) {
        for (User user : usersList) {
            if (user.getUserName().equals(userName)) {
                return user.updatePassword(password);
            }
        }
        return false;
    }

    /**
     * Saves user data to a file with the provided file name.
     *
     * @param fileName The name of the file where user data will be saved.
     * @return true if the operation is successful, false otherwise.
     */
    public boolean saveUsers(String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(usersList);
            oos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}