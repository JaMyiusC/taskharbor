import java.util.ArrayList;
import java.util.HashMap;

/**
 * The ProjectManager class is responsible for managing project information.
 */
public class ProjectManager {
    private static ProjectManager projectManager;
    private ArrayList<Project> projects = new ArrayList<Project>();

    private ProjectManager() {
        projects = DataReader.getProjects();
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
        projects.add(project);
    }

    /**
     * Removes a project from the appropriate list based on its completion status.
     *
     * @param project The project to be removed.
     */
    public void removeProject(Project project) {
        projects.remove(project);
    }


    public ArrayList<Project> getAllProjects(){
        return projects;
    }

    public void saveProjects() {
        DataWriter.saveProjects();
    }
}