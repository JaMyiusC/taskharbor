import java.util.ArrayList;

public class Column {
    private String columnName;
    private int columnPosition;
    private Comments comments;
    private ArrayList<Task> columnTaskList;
    private ArrayList<Comments> commentsList;

    public Column(){
        this.columnName = "Default Column Name";
        this.columnPosition = 0;
        this.columnTaskList = new ArrayList<>();
        this.commentsList = new ArrayList<>();
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

    public void addComment(Comments newComment) {
        commentsList.add(newComment);
    }

    public int getPosition() {
        return columnPosition;
    }

    @Override
    public String toString() {
        return "Column Name: " + columnName + "\n" +
                "Column Position: " + columnPosition + "\n" +
                "Column Task List: " + columnTaskList + "\n";
    }
}
