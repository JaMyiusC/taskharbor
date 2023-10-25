import java.util.ArrayList;
import java.util.HashMap;

/**
 * The ProjectManager class is responsible for managing project information.
 */
public class ProjectManager {
    private static ProjectManager projectManager;
    private HashMap<Boolean, ArrayList<Project>> completionMap;

    private ProjectManager() {
        this.completionMap = new HashMap<>();
        this.completionMap.put(true, new ArrayList<>());  // Completed projects
        this.completionMap.put(false, new ArrayList<>()); // Incomplete projects
    }

    /**
     * Gets the instance of the ProjectManager using the Singleton pattern.
     *
     * @return The ProjectManager instance.
     */
    public static ProjectManager getInstance() {
        if (projectManager == null) {
            projectManager = new ProjectManager();
        }
        return projectManager;
    }

    /**
     * Adds a new project to the appropriate list based on its completion status.
     *
     * @param project The project to be added.
     */
    public void addProject(Project project) {
        completionMap.get(project.isCompleted()).add(project);
    }

    /**
     * Removes a project from the appropriate list based on its completion status.
     *
     * @param project The project to be removed.
     */
    public void removeProject(Project project) {
        completionMap.get(project.isCompleted()).remove(project);
    }

    /**
     * Retrieves the list of all projects based on their completion status.
     *
     * @param isCompleted The completion status of the projects to retrieve.
     * @return An ArrayList of Project objects representing all projects with the given completion status.
     */
    public ArrayList<Project> getProjectsByCompletionStatus(boolean isCompleted) {
        return completionMap.get(isCompleted);
    }
}