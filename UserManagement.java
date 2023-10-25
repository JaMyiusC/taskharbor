import java.util.ArrayList;

public class UserManagement {
    private static UserManagement userManager;
    private ArrayList<User> usersList;

    private UserManagement() {
        this.usersList = DataReader.getUsers();
    }

    public static UserManagement getInstance() {
        if(userManager == null){
            userManager = new UserManagement();
        }
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
