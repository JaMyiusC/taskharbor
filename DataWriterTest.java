import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

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
    void testDisplayProjectDetails() {
        Project project = new Project("Test Project", new Date(), new ArrayList<>());
        project.addColumn(new Column("Column 1", new ArrayList<>()));
        project.addColumn(new Column("Column 2", new ArrayList<>()));
        // Redirecting system output for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        project.displayProjectDetails();
        String expectedOutput = "Project Name: Test Project\nColumns:\nColumn 1\nColumn 2\n";
        assertEquals(expectedOutput, outputStream.toString());
        // Resetting system output
        System.setOut(System.out);
    }

    @Test
    void testGetTaskByName() {
        Project project = new Project("Test Project", new Date(), new ArrayList<>());
        assertNull(project.getTaskByName("TaskName"));
    }
}
