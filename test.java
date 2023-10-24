import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        // Create some User objects
        User user1 = new User(null, "user1", null, null, null, null, null, null, null);
        User user2 = new User(null, "user2", null, null, null, null, null, null, null);

        // Add the users to an ArrayList
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        // Create some Project objects
        Project project1 = new Project();
        Project project2 = new Project();

        // Add the projects to an ArrayList
        ArrayList<Project> projectList = new ArrayList<>();
        projectList.add(project1);
        projectList.add(project2);

        // Create a DataWriter and save the users and projects
        DataWriter dataWriter = new DataWriter(userList, projectList);
        boolean usersSaved = dataWriter.saveUsers();
        boolean projectsSaved = dataWriter.saveProjects();

        // Print whether the save operations were successful
        System.out.println("Users saved: " + usersSaved);
        System.out.println("Projects saved: " + projectsSaved);
    }
}
