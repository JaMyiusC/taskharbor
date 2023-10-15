import java.util.ArrayList;
import java.util.Date;

// The Task class is responsible for managing task information.
public class Task {
    // The name of the task.
    private String taskName;
    // The priority of the task.
    private int taskPriority;
    // An ArrayList to store the tags of the task.
    private ArrayList<String> taskTags;
    // The due date of the task.
    private Date taskDueDate;
    // The creation date of the task.
    private Date taskCreationDate;
    // The completion status of the task.
    private boolean taskCompletion;
    // The notes related to the task.
    private String taskNotes;

    // Constructor for the Task class.
    public Task() {
        this.taskName = "";
        this.taskPriority = 0;
        this.taskTags = new ArrayList<>();
        this.taskDueDate = new Date();
        this.taskCreationDate = new Date();
        this.taskCompletion = false;
        this.taskNotes = "";
    }

    // Overridden toString method to provide a string representation of the Task object.
    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskPriority=" + taskPriority +
                ", taskTags=" + taskTags +
                ", taskDueDate=" + taskDueDate +
                ", taskCreationDate=" + taskCreationDate +
                ", taskCompletion=" + taskCompletion +
                ", taskNotes='" + taskNotes + '\'' +
                '}';
    }
}
