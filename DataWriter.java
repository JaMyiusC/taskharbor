import java.util.ArrayList;

public class DataWriter {
    private ArrayList<User> userList;
    private ArrayList<Project> projectList; // Assuming you have a Project class

    public DataWriter(ArrayList<User> userList, ArrayList<Project> projectList) {
        this.userList = userList;
        this.projectList = projectList;
    }

    public boolean saveUsers() {
        // Here, we'll just print the users as an example.
        for (User user : userList) {
            System.out.println("Saved user: " + user.getUserName());
        }
        return true; // Indicate successful save
    }

    public boolean saveProjects() {
        // Here, we'll just print the projects as an example.
        for (Project project : projectList) {
            System.out.println("Saved project: " + project.getProjectName()); // Assuming getProjectName() method in Project class
        }
        return true; // Indicate successful save
    }
}