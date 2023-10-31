import java.util.ArrayList;

public class Column {
    private static String columnName;
    private static int columnPosition;
    private ArrayList<Task> columnTaskList;

<<<<<<< HEAD
    public Column(String columnName, int columnPosition) {
        Column.columnName = columnName;
        Column.columnPosition = columnPosition;
=======
    public Column(String columnName, int columnPosition, ArrayList<Task> columnTaskList ) {
        this.columnName = columnName;
        this.columnPosition = columnPosition;
>>>>>>> 6197dbd093d129af4b832acf8547716a2fa149dc
        this.columnTaskList = new ArrayList<>();
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
}
