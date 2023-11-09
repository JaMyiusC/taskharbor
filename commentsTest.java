import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CommentsTest {

    private Comments comments;

    @BeforeEach
    public void setup() {
        comments = new Comments("John", "User Comments");
    }

    @AfterEach
    public void tearDown() {
        comments = null;
    }

    @Test
    void testAddComment() {
        comments.addComment("Comment 1");
        comments.addComment("Comment 2");

        ArrayList<String> commentList = comments.getComment();

        assertEquals(2, commentList.size());
        assertTrue(commentList.contains("Comment 1"));
        assertTrue(commentList.contains("Comment 2"));
    }

    @Test
    void testRemoveComment() {
        comments.addComment("Comment 1");
        comments.addComment("Comment 2");

        boolean removed = comments.removeComment("Comment 1");
        assertTrue(removed);

        ArrayList<String> commentList = comments.getComment();

        assertEquals(1, commentList.size());
        assertFalse(commentList.contains("Comment 1"));
        assertTrue(commentList.contains("Comment 2"));
    }

    @Test
    void testGetUser() {
        assertEquals("John", comments.getUser());
    }

    @Test
    void testGetCommentText() {
        assertEquals("User Comments", comments.getCommentText());
    }

    @Test
    void testToString() {
        String expectedString = "Comments{user=John, comments=[]}";
        assertEquals(expectedString, comments.toString());
    }
}

