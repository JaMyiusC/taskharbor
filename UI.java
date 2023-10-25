import java.util.ArrayList;

public class UI {

    public void run() {
        scenario4();
    }

    public void scenario1() {
        // Test creating a new user with a random UUID
      /* User newUser = new User("Alice", "Johnson", "alicej", "password123", "alice@example.com", "9876543210", "1990-05-15", "456 Main St, City, Country");
        System.out.println("New User:\n" + newUser.toString());

        // Test saving user data to JSON
        newUser.saveToJsonArray("json/users.json");
        System.out.println("User data saved to JSON.");

        // Test loading user data from JSON
        User loadedUser = User.loadFromJson("json/users.json");
        if (loadedUser != null) {
            System.out.println("\nLoaded User:\n" + loadedUser.toString());
        } else {
            System.out.println("Failed to load user data from JSON.");
        }
        */
    }

    public void scenario2() {
        ArrayList<User> users = DataReader.getUsers();
        for(User user : users){
            System.out.println(user);
        }
    }

    public void scenario3(){
        DataWriter.saveUsers();
    }

    public void scenario4() {
        UiFacade facade = new UiFacade();
        facade.addUser("Jenny", "Smith", "....", null, null, null, null, null);
        facade.login("jsmith", "12345");

        System.out.println(facade.getCurrentUser());

        facade.logout();
    }

    public static void main(String[] args) {
        UI myTest = new UI();
        myTest.run();
    }
}



