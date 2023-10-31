/*import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Project {
    private TaskManagement taskManager;
    private columnManager columnManager;
    private HashMap<String, ArrayList<User>> groups;
    private String projectName;
    private String projectID;
    private Date projectDate;
    private String comment;

    public Project() {
        this.taskManager = new TaskManagement();
        this.columnManager = new columnManager();
        this.projectID = "";
        this.projectName = "";
        this.projectDate = new Date();
    }

    public boolean createGroup(String groupName) {
        if (!groups.containsKey(groupName)) {
            groups.put(groupName, new ArrayList<>());
            return true;
        }
        return false; // Group already exists.
    }

    public boolean addUserToGroup(String group, String userName) {
        ArrayList<User> groupUsers = groups.get(group);
        if (groupUsers != null) {
            for (User user : groupUsers) {
                if (user.getUserName().equals(userName)) {
                    return false; // User already in the group.
                }
            }
            //groupUsers.add(new User(null, userName, userName, userName, userName, userName, userName, userName, userName)); // Assuming User has a constructor that takes userName.
            return true;
        }
        return false; // Group doesn't exist.
    }

    public boolean removeUserInGroup(String group, String userName) {
        ArrayList<User> groupUsers = groups.get(group);
        if (groupUsers != null) {
            return groupUsers.removeIf(user -> user.getUserName().equals(userName));
        }
        return false; // Group doesn't exist.
    }

    public ArrayList<User> viewGroup(String groupName) {
        return groups.get(groupName);
    }

	public String getProjectName() {
		return projectName;
	}

    public Object getProjectId() {
        return projectID;
    }
}
 */
import java.util.Date;
import java.util.UUID;

public class Project {
    private String projectName;
    private Date projectDate;
    private UUID projectId;
    private boolean completed; // New field to track completion status

    // Constructor for the Project class
    public Project(String projectName, Date projectDate) {
        this.projectName = projectName;
        this.projectDate = projectDate;
        this.projectId = UUID.randomUUID();
        this.completed = false; // A new project is not completed by default
    }

    public Date getProjectDate() {
        return projectDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Method to mark the project as completed
    public void markCompleted() {
        completed = true;
    }

    public Object getProjectId() {
        return projectId;
    }
}
 