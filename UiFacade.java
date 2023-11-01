import java.util.ArrayList;
import java.util.Date;

public class UiFacade {
    // Add fields for managing tasks, columns, etc.

    private User user;
    private Project currentProject;
    public UiFacade() {
        // Initialize other managers and data structures
    }

    //add a login method, and a signup method, each is one line and just calls the appropriate method on the usermanager

    public boolean userLogin(String userName, String userPassword) {
    user = UserManagement.getInstance().getUser(userName, userPassword);
    return user != null;
    }

    public void login(String userName, String userPassword) {
        if (userLogin(userName, userPassword)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }
    
    public void logout() {
            ProjectManager.getInstance().saveProjects();
            UserManagement.getInstance().saveUsers();
            user = null; // Reset the current user after logout
    }

    // Task-related methods

    public Project addProject(String name, Date date, ArrayList<Column> columns){
        currentProject = new Project(name, date, columns);
        currentProject.saveProjects(currentProject);
        return currentProject;
    }

    public boolean addTask(String taskName, ArrayList<String> taskTags, String taskNotes) {
        if (user != null) {
            Task taskManager = Task.getInstance();
            Task task = new Task(taskName, taskTags, taskNotes);
            return taskManager.addTask(task, user);
        }
        return false; // User is not logged in
    }

    public boolean addUser(String firstName, String lastName, String userName, String password, String email, String phoneNumber, String address, String type) {
        if (user != null) {
            User newUser = new User(firstName, lastName, userName, password, email, phoneNumber, address); //?????????
            
            return UserManagement.getInstance().addUser(firstName, lastName, userName, password, email, phoneNumber, address);
        }
        return false; // User is not logged in or is not an admin
    }

    public Object getCurrentUser() {
        return user;
    }
   
    public boolean addColumn(String columnName, ArrayList<Task> tasks) {
        if (user != null) {
            Column column = Column.getInstance();
            Column newColumn = new Column(columnName, tasks);
            return column.addColumn(newColumn, tasks);
        }
        return false; // User is not logged in
    }
    
    public boolean addTask(String taskName, String taskNotes, int taskPriority, Date date, String taskComments) {
        if (user != null) {
            Task task = Task.getInstance();

            // Create a new task using the provided information
            Task newTask = new Task(taskName, taskNotes, taskPriority, date, taskComments);
            // Add the task using the TaskManager
            return task.addTask(newTask, user);
        }
        return false; // User is not logged in
    }

    public boolean addTaskComments(String taskName, String comment) {
        if (user != null) {
            Task taskManager = Task.getInstance();

            // Call the addComment method in TaskManager
            return taskManager.addComment(taskName, comment, user);
        }
        return false; // User is not logged in
    }

    public static void main(String[] args){
        //?
    }
    
}
