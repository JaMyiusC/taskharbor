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
    private Role userRole;
    private ArrayList<String> userHistory;

    public static void main(String[] args) {
    	// Create a new User object
        User thisUser = new User(UUID.randomUUID(), "John", "Doe", "johndoe", "password123", "johndoe@example.com", "1234567890", "01-01-1990", "123 Street, City, Country");

        // Print the User object
        System.out.println(thisUser.toString());

        // Check password
        System.out.println("Password check: " + thisUser.checkPassword("password123"));

        // Update password
        thisUser.updatePassword("newPassword123");
        System.out.println("Updated password check: " + thisUser.checkPassword("newPassword123"));

        // Confirm user
        System.out.println("User confirmation: " + thisUser.confirmUser("johndoe", "newPassword123"));

        // Add and view user task history
        thisUser.addUserTaskHistory("Task 1 completed");
        System.out.println("User task history: " + thisUser.viewUserTaskHistory());

        // Add and view user column history
        thisUser.addUserColumnHistory("Column 1 updated");
        System.out.println("User column history: " + thisUser.viewUserColumnHistory());
    }

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
        this.userRole = Role.Contributor; // Default role
        this.userHistory = new ArrayList<>();
    }

    // overload the constructor 

    public User() {
		// TODO Auto-generated constructor stub
	}

	public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean updatePassword(String newPassword) {
        this.password = newPassword;
        return true;
    }

    @Override
    public String toString() {
        return "User ID: " + id +
               "\nFirst Name: " + firstName +
               "\nLast Name: " + lastName +
               "\nUsername: " + userName +
               "\nEmail: " + email +
               "\nPhone Number: " + phoneNumber +
               "\nBirthday: " + birthday +
               "\nAddress: " + address +
               "\nUser Role: " + userRole;
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

	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}
}