import static org.junit.Assert.*;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.junit.Test;
public class DataWriterTest {
    private User user = User.getInstance();
	private ArrayList<User> userList = user.getUser();

    @Test
    void testSaveUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Meet", "Patel", "mpatel", "meet2002..."));

        DataWriter.saveUsers();
    }

    @Test
    void testSaveTasks() {
        userList = DataWriter.saveUsers();
		assertEquals(0, userList.size());
    }

    @Test
    void testSaveColumns() {
        userList = DataWriter.saveUsers();
		assertEquals(0, userList.size());
    }

    @Test
    void testSaveProjects() {
        userList = DataWriter.saveUsers();
		assertEquals(0, userList.size());
    }
}

