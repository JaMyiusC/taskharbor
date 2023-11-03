import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;;

public class DataWriter {
    public static void saveUsers() {
		ArrayList<User> users = UserManagement.getInstance().getUserList();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(User user: users) {
			jsonUsers.add(getUserJSON(user));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("json/users.json")) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void saveTasks() {
		ArrayList<Task> tasks = TaskManagement.getInstance().getTaskList();
		JSONArray jsonTasks = new JSONArray();

		for(Task task: tasks) {
			jsonTasks.add(getTaskJSON(task));

		}

		try(FileWriter file = new FileWriter("json/project.json")){

			file.write(jsonTasks.toJSONString());
			file.flush();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void saveColumns() {
		ArrayList<Column> columns = Column.getAllColumns();
		JSONArray jsonColumns = new JSONArray();
		
		try (FileWriter file = new FileWriter("json/project.json")) {
			file.write(columns.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	public static void saveProjects() {
		ArrayList<Project> projects = ProjectManager.getInstance();
		JSONArray jsonProjects = new JSONArray();
	
		for (Project project : projects) {
			jsonProjects.add(getProjectJSON(project));
		}
	
		try (FileWriter file = new FileWriter("json/projects.json")) {
			file.write(jsonProjects.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static JSONObject getProjectJSON(Project project) {
		JSONObject projectDetails = new JSONObject();
		projectDetails.put("id", project.getProjectId());
		projectDetails.put("name", project.getProjectName());
		// Add any other properties of the Project class that you want to save here.
		return projectDetails;
	}	
	
	
	public static JSONObject getColumnJSON(Column column) {
		JSONObject columnDetails = new JSONObject();
		columnDetails.put("id", Column.getPosition());
		columnDetails.put("name", Column.getName());
		
		return columnDetails;
	}

	public static JSONObject getUserJSON(User user) {
		JSONObject personDetails = new JSONObject();
		personDetails.put("id", user.getId().toString());
		personDetails.put("firstName", user.getFirstName());
		personDetails.put("lastName", user.getLastName());
        personDetails.put("userName", user.getUserName());
		personDetails.put("password", user.getPassword());
		personDetails.put("email", user.getEmail());
		personDetails.put("phoneNumber", user.getPhoneNumber());
		personDetails.put("address", user.getAddress());
		personDetails.put("userRole", user.getUserRole().toString());
        return personDetails;
	}

	public static JSONObject getTaskJSON(Task task){
		JSONObject taskDetails = new JSONObject();
		taskDetails.put("taskName", task.getTaskName());
		taskDetails.put("taskPriority", task.getTaskPriority());
		taskDetails.put("taskTags", task.getTaskTags());
		taskDetails.put("taskDueDate", task.getTaskDueDate());
		taskDetails.put("taskNotes", task.getTaskNotes());
		taskDetails.put("taskCompletion", task.getTaskCompletion());
		return taskDetails;
	}
}
