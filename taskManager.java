import java.util.ArrayList;
import java.util.HashMap;

public class taskManager {
    // Attributes
    private HashMap<Boolean, ArrayList<Task>> taskList;

    // Constructor
    public taskManager() {
        this.taskList = new HashMap<>();
    }

    // Methods
    public boolean addTask(Task task) {
        // Implementation to add a task to the manager
        return false;
    }

    public boolean removeTask(Task task) {
        // Implementation to remove a task from the manager
        return false;
    }

    public Task getTask(String taskName) {
        // Implementation to get a specific task by name
        return null;
    }

    public boolean hasTask(String taskName) {
        // Implementation to check if a task exists in the manager
        return false;
    }

    public boolean editTaskPriority(String taskName, int taskPriority) {
        // Implementation to edit the priority of a task
        return false;
    }

    public boolean editTask(String taskName) {
        // Implementation to edit the properties of a task
        return false;
    }

    public boolean saveTaskList() {
        // Implementation to save the task data
        return false;
    }

    public boolean markTaskComplete(String taskName) {
        // Implementation to mark a task as complete
        return false;
    }

    public boolean markTaskWorkingOn(String taskName) {
        // Implementation to mark a task as 'working on'
        return false;
    }
}
