import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;;

public class DataWriter {
    private ArrayList<User> userList;
    private ArrayList<Project> projectList; // Assuming you have a Project class

    public DataWriter(ArrayList<User> userList, ArrayList<Project> projectList) {
        this.userList = userList;
        this.projectList = projectList;
    }

    public boolean saveUsers() {
        // In a real application, you would save the userList to a database or a file.
        // Here, we'll just print the users as an example.
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (User user : userList) {
                fileWriter.write("Saved user: " + user.getUserName() + "\n");
            }
            return true; // Indicate successful save
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Indicate failure to save
        }
    }

    public boolean saveProjects() {
        // In a real application, you would save the projectList to a database or a file.
        // Here, we'll just print the projects as an example.
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Project project : projectList) {
                fileWriter.write("Saved project: " + project.getProjectName() + "\n");
            }
            return true; // Indicate successful save
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Indicate failure to save
        }
    }
}