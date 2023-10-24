import java.util.UUID;

public class test {
    public static void main(String[] args) {
        // Test User creation with random UUID
        User randomUser = new User("John", "Doe", "johndoe", "password123", "johndoe@example.com", "1234567890", "01-01-1990", "123 Street, City, Country");
        System.out.println("Random User:\n" + randomUser.toString());

        // Test User creation with predefined UUID
        UUID predefinedUUID = UUID.fromString("f546c57a-47e8-4aa1-8ba8-d186d7a15637");
        User predefinedUser = new User(predefinedUUID, "Jane", "Smith", "janesmith", "pass456", "janesmith@example.com", "9876543210", "02-02-1995", "456 Avenue, Town, Country");
        System.out.println("\nPredefined User:\n" + predefinedUser.toString());

        // Test password update
        System.out.println("\nPassword check: " + predefinedUser.checkPassword("pass456"));
        predefinedUser.updatePassword("newPass789");
        System.out.println("Updated password check: " + predefinedUser.checkPassword("newPass789"));

        // Test user confirmation
        System.out.println("\nUser confirmation: " + predefinedUser.confirmUser("janesmith", "newPass789"));

        // Test user task history
        predefinedUser.addUserTaskHistory("Task 1 completed");
        predefinedUser.addUserTaskHistory("Task 2 started");
        System.out.println("\nUser task history:\n" + predefinedUser.viewUserTaskHistory());

        // Test user column history
        predefinedUser.addUserColumnHistory("Column 1 updated");
        predefinedUser.addUserColumnHistory("Column 2 added");
        System.out.println("\nUser column history:\n" + predefinedUser.viewUserColumnHistory());
    }
}
