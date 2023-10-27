import java.util.ArrayList;

public class Column {
    private String columnName;
    private int columnPosition;
    private ArrayList<Task> columnTaskList;

    public Column(String columnName, int columnPosition) {
        this.columnName = columnName;
        this.columnPosition = columnPosition;
        this.columnTaskList = new ArrayList<>();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ArrayList<Task> getColumnTaskList() {
        return columnTaskList;
    }

    public boolean addColumnTask(Task task) {
        return columnTaskList.add(task);
    }

    public boolean removeColumnTask(Task task) {
        return columnTaskList.remove(task);
    }

    @Override
    public String toString() {
        return "Column Name: " + columnName + ", Position: " + columnPosition;
    }
}
