import java.util.ArrayList;

public class Column {
    private static String columnName;
    private static ArrayList<Task> columnTaskList;

    public Column(String columnName) {
        Column.columnName = columnName;
    }
    public Column(String columnName, ArrayList<Task> columnTaskList ) {
        this.columnName = columnName;
        this.columnTaskList = columnTaskList;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        Column.columnName = columnName;
    }

    public static ArrayList<Task> getColumnTaskList() {
        return columnTaskList;
    }

    public boolean addColumnTask(Task task) {
        return columnTaskList.add(task);
    }

    public boolean removeColumnTask(Task task) {
        return columnTaskList.remove(task);
    }

    public static String getName() {
        return columnName;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for(int i=0; i<columnTaskList.size();i++)
        {
            toReturn += columnTaskList.get(i).toString();
        }

        return "Column Name: " + columnName + "\n" + toReturn;
    }
}

