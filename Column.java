import java.util.ArrayList;

public class Column {
    private String columnName;
    private int columnPosition;
    private ArrayList<Task> columnTaskList;

    // Constructor to initialize the column name, position, and task list
    public Column(String columnName, int columnPosition) {
        this.columnName = columnName;
        this.columnPosition = columnPosition;
        this.columnTaskList = new ArrayList<>();
    }

    // Add a task to the column's task list
    public boolean addTaskForColumn(String taskName) {
        // Placeholder implementation
        return false;
    }

    // Remove a task from the column's task list
    public boolean removeTaskForColumn(String taskName) {
        // Placeholder implementation
        return false;
    }

    // Get the list of tasks in the column
    public ArrayList<Task> getColumnTaskList() {
        // Placeholder implementation
        return columnTaskList;
    }

    @Override
    public String toString() {
        // Placeholder implementation
        return columnName;
    }
}