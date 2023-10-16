import java.util.ArrayList;
import java.util.Date;

public class changeHistory {
    private ArrayList<String> taskHistory;
    private Date date;

    // Constructor to initialize the taskHistory and date
    public changeHistory() {
        this.taskHistory = new ArrayList<>();
        this.date = new Date();
    }

    // Get an instance of ChangeHistory
    public static changeHistory getInstance() {
        return new changeHistory();
    }

    // View the task history
    public ArrayList<String> viewTaskHistory() {
        return taskHistory;
    }

    // Add a history entry to the task history
    public void addTaskHistory(String historyEntry) {
        taskHistory.add(historyEntry);
    }
}
