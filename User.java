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
    private role userRole;
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
        return this.password.equals(password);
    }

    public boolean updatePassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password = password;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    public boolean confirmUser(String userName, String password) {
        return this.userName.equals(userName) && this.password.equals(password);
    }

    public ArrayList<String> viewUserTaskHistory() {
        return userHistory;
    }

    public void addUserTaskHistory(String historyEntry) {
        userHistory.add(historyEntry);
    }

    public ArrayList<String> viewUserColumnHistory() {
        return userHistory;
    }

    public void addUserColumnHistory(String columnHistory) {
        userHistory.add(columnHistory);
    }
}