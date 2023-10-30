import java.util.ArrayList;
import java.util.HashMap;

public class columnManager {
    // Attributes
    private static columnManager columnManagerInstance;
    private HashMap<Boolean, ArrayList<Column>> columnList;
    
    // Constructor
    public columnManager() {
        this.columnList = new HashMap<>();
    }
    
    public static columnManager getInstance(){
        if(columnManagerInstance == null){
            columnManagerInstance = new columnManager();
        }
        return columnManagerInstance;
    }
    // Methods
    public boolean addColumn(Column column) {
        ArrayList<Column> incompleteColumns = columnList.get(Boolean.FALSE);

        if (incompleteColumns != null){
            incompleteColumns.add(column);
            return true;
        }
        return false;
    }

    public boolean removeColumn(Column column) {
        // Implementation to remove a column from the manager
        for (ArrayList<Column> columns : columnList.values()){
            if(columns != null) {
                boolean removed = columns.remove(column);
                if(removed){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasColumn(String columnName) {
        // Implementation to check if a column exists in the manager
        for (ArrayList<Column> columns : columnList.values()){
            for (Column column : columns){
                if(column.getColumnName().equals(columnName)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean editColumnName(String columnName, String newColumnName) {
        // Implementation to edit the name of a column
        for (ArrayList<Column> columns : columnList.values()){
            for (Column column : columns){
                if(column.getColumnName().equals(columnName)){
                    column.setColumnName(newColumnName);
                    return true;
                }
            }
        }
        return false;
    }
    
    public Column getColumn(String columnName) {
        // Implementation to get a specific column by name
        for (ArrayList<Column> columns : columnList.values()) {
            for (Column column : columns) {
                if (column.getColumnName().equals(columnName)) {
                    return column;
                }
            }
        }
        return null;
    }

    public boolean addTaskToColumn(Task task, Column column) {
        // Implementation to add a task to a specific column
        if (column != null) {
            return column.addColumnTask(task);
        }
        return false;
    }

    public boolean removeTaskFromColumn(Task task, Column column) {
        // Implementation to remove a task from a specific column
        if (column != null) {
            return column.removeColumnTask(task);
        }
        return false;
    }

    public boolean saveTasks() {
        // Implementation to save the column data
         DataWriter.saveTasks();
         return true;
    }

    public ArrayList<Column> getColumnList() {
        ArrayList<Column> allColumns = new ArrayList<>();

        allColumns.addAll(columnList.get(false));

        allColumns.addAll(columnList.get(true));

        return allColumns;
    }

}