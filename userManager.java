<<<<<<< Updated upstream
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * The UserManager class is responsible for managing user information.
 */
public class userManager {
    private static userManager userManager;
=======
import java.util.ArrayList;

public class UserManager {
    private static UserManager userManager;
>>>>>>> Stashed changes
    private ArrayList<User> usersList;

    private userManager() {
        this.usersList = new ArrayList<>();
    }

<<<<<<< Updated upstream
    /**
     * Gets the instance of the UserManager using the Singleton pattern.
     *
     * @return The UserManager instance.
     */
    public static userManager getInstance() {
        if (userManager == null) {
            userManager = new userManager();
        }
=======
   
    public static UserManager getInstance() {
>>>>>>> Stashed changes
        return userManager;
    }

    public boolean addUser(String firstName, String lastName, String userName, String password, String email, String phoneNumber, String birthdate, String address, String type) {
        return true;
    }

    public boolean removeUser(String userName, String password) {
        return false;
    }

    public User getUser(String userName) {
        return null;
    }

    public ArrayList<User> getUserList() {
        return usersList;
    }

    public boolean hasUser(String userName) {
        return false;
    }

    public boolean editUserPassword(String userName, String password) {
        return false;
    }

    public boolean saveUsers(String fileName) {
        return false;
    }

}
