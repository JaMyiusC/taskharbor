import static org.junit.Assert.*;
import org.junit.Test;

public class ChangeHistoryTest {

    private ChangeHistory changeHistory;

    @BeforeEach
    public void setup() {
        changeHistory = ChangeHistory.getInstance();
    }

    @AfterEach
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
