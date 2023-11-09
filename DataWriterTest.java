import static org.junit.Assert.*;
import org.junit.Test;

public class DataWriterTest {
    private User user = User.getInstance();
	private ArrayList<User> userList = user.getUser();
	

    @BeforeEach
    public void setup() {
        // Initialize any necessary data or objects before each test if needed.
    }

    @Test
    void testSaveUsers() {
        // Add test cases to validate the saveUsers method of DataWriter.
        // You may need to mock or set up data as required for the test.
    }

    @Test
    void testSaveTasks() {
        // Add test cases to validate the saveTasks method of DataWriter.
        // You may need to mock or set up data as required for the test.
    }

    @Test
    void testSaveColumns() {
        // Add test cases to validate the saveColumns method of DataWriter.
        // You may need to mock or set up data as required for the test.
    }

    @Test
    void testSaveProjects() {
        // Add test cases to validate the saveProjects method of DataWriter.
        // You may need to mock or set up data as required for the test.
    }
}

