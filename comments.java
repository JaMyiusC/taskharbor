import java.util.ArrayList;

// The Comments class is responsible for managing comments related to a user.
public class comments {
    // The User who owns these comments.
    private static String user;
    // An ArrayList to store the comments.
    private static String commentText;
    private static ArrayList<String> comments;

    // Constructor for the Comments class.
    public comments(String user, String commentText) {
        this.user = user;
        this.commentText = commentText;
        this.comments = new ArrayList<>();
    }

    // Method to add a comment. Returns true if the comment was added successfully.
    public boolean addComment(String comment) {
        return comments.add(comment);
    }

    public String addCommentText(){
        return commentText;
    }

    // Method to remove a comment. Returns true if the comment was removed successfully.
    public boolean removeComment(String comment) {
        return comments.remove(comment);
    }

    public static String getUser(){
        return user;
    }

    public static ArrayList<String> getComment(){
        return comments;
    }
    

    // Overridden toString method to provide a string representation of the Comments object.
    @Override
    public String toString() {

        return "Comments{" +
                "user=" + user +
                ", comments=" + comments +
                '}';
    }
}