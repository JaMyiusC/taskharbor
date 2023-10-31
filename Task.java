
import java.util.Date;

public class Task {
    // Attributes
    private String taskName;
    private int taskPriority;
    private Date taskDueDate;
    private String taskNotes;
    private boolean taskCompletion;

    // Constructor
    public Task(String taskName, int taskPriority, Date taskDueDate, String taskNotes) {
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.taskDueDate = taskDueDate;
        this.taskNotes = taskNotes;
        this.taskCompletion = false; // Initialize as not completed
    }

    // Getters and Setters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Date getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(Date taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public String getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(String taskNotes) {
        this.taskNotes = taskNotes;
    }

    public boolean getTaskCompletion() {
        return taskCompletion;
    }

    public void setTaskCompletion(boolean taskCompletion) {
        this.taskCompletion = taskCompletion;
    }

    // Additional Methods
    public void markComplete() {
        taskCompletion = true;
    }

    public void markWorkingOn() {
        taskCompletion = false;
    }

    @Override
    public String toString() {
        return "Task Name: " + taskName +
               "\nPriority: " + taskPriority +
               "\nDue Date: " + taskDueDate +
               "\nNotes: " + taskNotes +
               "\nCompletion: " + (taskCompletion ? "Completed" : "Not Completed");
    }
}


