public class test {
    public static void main(String[] args) {
        // Test creating a new user with a random UUID
        User newUser = new User("Alice", "Johnson", "alicej", "password123", "alice@example.com", "9876543210", "1990-05-15", "456 Main St, City, Country");
        System.out.println("New User:\n" + newUser.toString());

        // Test saving user data to JSON
        newUser.saveToJson("user_data.json");
        System.out.println("User data saved to JSON.");

        // Test loading user data from JSON
        User loadedUser = User.loadFromJson("user_data.json");
        if (loadedUser != null) {
            System.out.println("\nLoaded User:\n" + loadedUser.toString());
        } else {
            System.out.println("Failed to load user data from JSON.");
        }
    }
}



