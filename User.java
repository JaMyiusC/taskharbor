import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private Role userRole;

    // Constructor for creating a new user with a random UUID
    public User(String firstName, String lastName, String userName, String password, String email, String phoneNumber,String address) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userRole = Role.Contributor; // Default role
    }

    // Constructor for creating a user from JSON data with a predefined UUID
    public User(UUID id, String firstName, String lastName, String userName, String password, String email, String phoneNumber, String address, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userRole = role;
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
        return "User ID: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nUsername: " + userName + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nAddress: " + address + "\nUser Role: " + userRole;
    }

    public boolean confirmUser(String userName, String password) {
        return this.userName.equals(userName) && this.password.equals(password);
    }

	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

    public UUID getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public  String getPhoneNumber(){
        return phoneNumber;
    }

    public String getAddress(){
        return address;
    }

    public Role getUserRole(){
        return userRole;
    }

}