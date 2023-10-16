import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String birthday;
    private String address;
    private String userRole;
    private ArrayList<String> userHistory;

    public User(UUID id, String firstName, String lastName, String userName, String password, String email, String phoneNumber, String birthday, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.address = address;
        this.userRole = "user"; // Default role
        this.userHistory = new ArrayList<>();
    }

    public boolean checkPassword(String password) {
        return false;
    }

    public boolean updatePassword(String password) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    public boolean confirmUser(String userName, String password) {
        return true;
    }

    public ArrayList<String> viewUserTaskHistory() {
        return null;
    }

    public void addUserTaskHistory(String historyEntry) {
        return ;
    }

    public ArrayList<String> viewUserColumnHistory() {
        return null;
    }

    public void addUserColumnHistory(String columnHistory) {
        return ;
    }
}