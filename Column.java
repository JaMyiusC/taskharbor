import java.util.ArrayList;


public class Column {
    private String columnName;
    private int columnPosition;
    private ArrayList<Task> columnTaskList;

    /**
     * Constructor to initialize a new column with a name and position.
     *
     * @param columnName     The name of the column.
     * @param columnPosition The position of the column.
     */
    public Column(String columnName, int columnPosition) {
        this.columnName = columnName;
        this.columnPosition = columnPosition;
        this.columnTaskList = new ArrayList<>();
    }

    /**
     * Adds a new task to the column's task list.
     *
     * @param taskName The name of the task to add.
     * @return true if the task was successfully added, false otherwise.
     */
    public boolean addTaskForColumn(String taskName) {
        Task task = new Task(taskName);
        return columnTaskList.add(task);
    }

    /**
     * Removes a task from the column's task list by its name.
     *
     * @param taskName The name of the task to remove.
     * @return true if the task was successfully removed, false otherwise.
     */
    public boolean removeTaskForColumn(String taskName) {
        Task taskToRemove = null;
        for (Task task : columnTaskList) {
            if (task.getTaskName().equals(taskName)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            return columnTaskList.remove(taskToRemove);
        }
        return false;
    }

    /**
     * Get the list of tasks in the column.
     *
     * @return An ArrayList of tasks in the column.
     */
    public ArrayList<Task> getColumnTaskList() {
        return columnTaskList;
    }

    /**
     * Returns the string representation of the column, which is its name.
     *
     * @return The name of the column.
     */
    @Override
    public String toString() {
        return columnName;
    }
}