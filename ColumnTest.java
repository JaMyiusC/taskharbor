import static org.junit.Assert.*;
import org.junit.Test;

public class ColumnTest {

    private Column column;

    @Test
    public void setup() {
        column = new Column();
    }

    @Test
    public void tearDown() {
        column = null;
    }

    @Test
    void testGetColumnName() {
        assertEquals("Default Column Name", column.getColumnName());
    }

    @Test
    void testSetColumnName() {
        column.setColumnName("Test Column Name");
        assertEquals("Test Column Name", column.getColumnName());
    }

    @Test
    void testAddColumnTask() {
        Task task = new Task("Task 1");
        assertTrue(column.addColumnTask(task));
        assertTrue(column.getColumnTaskList().contains(task));
    }

    @Test
    void testRemoveColumnTask() {
        Task task = new Task("Task 1");
        column.addColumnTask(task);
        assertTrue(column.removeColumnTask(task));
        assertFalse(column.getColumnTaskList().contains(task));
    }

    @Test
    void testAddComment() {
        Comments comment = new Comments("Test Comment");
        column.addComment(comment);
        assertTrue(column.getCommentsList().contains(comment));
    }

    @Test
    void testGetPosition() {
        assertEquals(0, column.getPosition());
    }

    @Test
    void testToString() {
        String expectedString = "Column Name: Default Column Name\n" +
                "Column Position: 0\n" +
                "Column Task List: []\n";
        assertEquals(expectedString, column.toString());
    }
}
