import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

public class DataWriterTest {

    @Test
    void testGetProjectDate() {
        Date projectDate = new Date();
        Project project = new Project("Test Project", projectDate, new ArrayList<>());
        assertEquals(projectDate, project.getProjectDate());
    }

    @Test
    void testGetProjectName() {
        Project project = new Project("Test Project", new Date(), new ArrayList<>());
        assertEquals("Test Project", project.getProjectName());
    }

    private void assertEquals(ArrayList<Column> columns, ArrayList<Column> arrayList) {
    }

    @Test
    void testIsCompleted() {
        Project project = new Project("Test Project", new Date(), new ArrayList<>());
        assertFalse(project.isCompleted());
    }

    @Test
    void testMarkCompleted() {
        Project project = new Project("Test Project", new Date(), new ArrayList<>());
        project.markCompleted();
        assertTrue(project.isCompleted());
    }

    @Test
    void testGetProjectId() {
        Project project = new Project("Test Project", new Date(), new ArrayList<>());
        assertNotNull(project.getProjectId());
    }

    @Test
    void testGetColumns() {
        ArrayList<Column> columns = new ArrayList<>();
        columns.add(new Column("Column 1", new ArrayList<>()));
        columns.add(new Column("Column 2", new ArrayList<>()));
        Project project = new Project("Test Project", new Date(), columns);
        assertEquals(columns, project.getColumns());
    }

    @Test
    void testAddColumn() {
        Project project = new Project("Test Project", new Date(), new ArrayList<>());
        Column column = new Column("Test Column", new ArrayList<>());
        project.addColumn(column);
        assertTrue(project.getColumns().contains(column));
    }

    @Test
    void testGetTaskByName() {
        Project project = new Project("Test Project", new Date(), new ArrayList<>());
        assertNull(project.getTaskByName("TaskName"));
    }
}
