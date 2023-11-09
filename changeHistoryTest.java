import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

class ChangeHistoryTest {

    private ChangeHistoryTest changeHistory;

    @Test
    public void setup() {
        changeHistory = ChangeHistoryTest.getInstance();
    }

    private static ChangeHistoryTest getInstance() {
        return null;
    }

    @Test
    public void tearDown() {
        changeHistory = null;
    }

    @Test
    void testViewTaskHistory() {
        ArrayList<String> taskHistory = changeHistory.viewTaskHistory();
        assertNotNull(taskHistory);
        assertTrue(taskHistory.isEmpty());
    }

    @Test
    void testAddTaskHistory() {
        changeHistory.addTaskHistory("Task updated: changed due date");
        ArrayList<String> taskHistory = changeHistory.viewTaskHistory();
        assertFalse(taskHistory.isEmpty());
        assertEquals(1, taskHistory.size());
        assertEquals("Task updated: changed due date", taskHistory.get(0));
    }
}
