import java.util.ArrayList;

// The Comments class is responsible for managing comments related to a user.
public class comments {
    // The User who owns these comments.
    private User user;
    // An ArrayList to store the comments.
    private ArrayList<String> comments;

    // Constructor for the Comments class.
    public comments(User user) {
        this.user = user;
        this.comments = new ArrayList<>();
    }

    // Method to add a comment. Returns true if the comment was added successfully.
    public boolean addComment(String comment) {
        return comments.add(comment);
    }

    // Method to remove a comment. Returns true if the comment was removed successfully.
    public boolean removeComment(String comment) {
        return comments.remove(comment);
    }

    // Method to check if a comment exists. Returns true if the comment exists.
    public boolean viewComment(String comment) {
        return comments.contains(comment);
    }

    // Method to edit a comment. Replaces 'oldComment' with 'newComment' and returns true if successful.
    public boolean editComment(String oldComment, String newComment) {
        int index = comments.indexOf(oldComment);
        if (index != -1) {
            comments.set(index, newComment);
            return true;
        }
        return false;
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