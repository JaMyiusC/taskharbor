import java.util.ArrayList;

public class Column {
    private static String columnName;
    private static int columnPosition;
    private ArrayList<Task> columnTaskList;

    public Column(String columnName, int columnPosition, ArrayList<Task> columnTaskList) {
        this.columnName = columnName;
        this.columnPosition = 0;
        this.columnTaskList = new ArrayList<>();
    }

    public static String getColumnName() {
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
        return "Column Name: " + columnName + "\n" +
                "Column Position: " + columnPosition + "\n" +
                "Column Task List: " + columnTaskList + "\n";
    }

    public static Column getInstance() {
        return Column.getInstance();
    }

    public static ArrayList<Column> getAllColumns() {
        ArrayList<Column> columns = new ArrayList<>();

        return columns;

    }

    public static int getPosition() {
        return columnPosition;
    }
}
