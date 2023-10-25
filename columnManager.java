import java.util.ArrayList;
import java.util.HashMap;

public class columnManager {
    // Attributes
    private HashMap<Boolean, ArrayList<Column>> columnList;
    
    // Constructor
    public columnManager() {
        this.columnList = new HashMap<>();
    }
    
    // Methods
    public boolean addColumn(Column column) {
        // Implementation to add a column to the manager
        return false;
    }

    public boolean removeColumn(Column column) {
        // Implementation to remove a column from the manager
        return false;
    }

    public boolean hasColumn(String columnName) {
        // Implementation to check if a column exists in the manager
        return false;
    }

    public boolean editColumnName(String columnName, String newColumnName) {
        // Implementation to edit the name of a column
        return false;
    }
    
    public Column getColumn(String columnName) {
        // Implementation to get a specific column by name
        return null;
    }

    public boolean addTaskToColumn(Task task, Column column) {
        // Implementation to add a task to a specific column
        return false;
    }

    public boolean removeTaskFromColumn(Task task, Column column) {
        // Implementation to remove a task from a specific column
        return false;
    }

    public boolean saveTaskList() {
        // Implementation to save the column data
        return false;
    }

    public boolean markTaskComplete(String taskName) {
        // Implementation to mark a task as complete in the columns
        return false;
    }
    
    public boolean markTaskWorkingOn(String taskName) {
        // Implementation to mark a task as 'working on' in the columns
        return false;
    }
}
