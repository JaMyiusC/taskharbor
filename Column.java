import java.util.ArrayList;

public class Column {
    private static String columnName;
    private static int columnPosition;
    private ArrayList<Task> columnTaskList;

    public Column(String columnName, int columnPosition, ArrayList<Task> columnTaskList ) {
        this.columnName = columnName;
        this.columnPosition = columnPosition;
        this.columnTaskList = new ArrayList<>();
    }

    public Column(String string, ArrayList<Task> columnTaskList2) {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        Column.columnName = columnName;
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

    public static int getPosition() {
        return columnPosition;
    }

    public static String getName() {
        return columnName;
    }

    @Override
    public String toString() {
        return "Column Name: " + columnName + ", Position: " + columnPosition;
    }

    public void addColumnTask(comments existingTask) {
    }
}
