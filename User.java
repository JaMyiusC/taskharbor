import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
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


    // Constructor for creating a new user with a random UUID
    public User(String firstName, String lastName, String userName, String password, String email, String phoneNumber, String birthday, String address) {
        this.id = UUID.randomUUID();
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

    // Constructor for creating a user from JSON data with a predefined UUID
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

// commented out for testing remove after the class is working
/*
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
*/
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

// Save user data to a JSON file
public void saveToJson(String filePath) {
    try (Writer writer = new FileWriter(filePath)) {
        writer.write(this.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// Load user data from a JSON file
public static User loadFromJson(String filePath) {
    try (Reader reader = new FileReader(filePath)) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder jsonContent = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            jsonContent.append(line);
        }

        // Parse JSON content and create a User object
        return parseJson(jsonContent.toString());
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}


private static User parseJson(String string) {
    //for testing purposes only
    return new User(UUID.randomUUID(), "Dummy", "User", "dummyuser", "dummyPassword", "dummy@example.com", "1234567890", "01-01-2000", "Dummy Address");
}


}