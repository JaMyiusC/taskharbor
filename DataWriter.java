import java.util.ArrayList;

public class DataWriter {
    private ArrayList<User> userList;

    public DataWriter(ArrayList<User> userList) {
        this.userList = userList;
    }

    public boolean saveUsers() {
        // In a real application, you would save the userList to a database or a file.
        // Here, we'll just print the users as an example.
        for (User user : userList) {
            System.out.println("Saved user: " + user.getUserName());
        }
        return true; // Indicate successful save
    }
}