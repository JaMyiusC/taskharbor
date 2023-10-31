import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;;

public class DataWriter {
    public static void saveUsers() {
		ArrayList<User> users = UserManagement.getInstance().getUserList();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< users.size(); i++) {
			jsonUsers.add(getUserJSON(users.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("json/users.json")) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void saveProjects() {
		ArrayList<Project> projects = ProjectManager.getInstance().getAllProjects();
		JSONArray jsonProjects = new JSONArray();
	
		for (Project project : projects) {
			jsonProjects.add(getProjectJSON(project));
		}
	
		try (FileWriter file = new FileWriter("json/projects-test.json")) {
			file.write(jsonProjects.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static JSONObject getProjectJSON(Project project) {
		JSONObject projectDetails = new JSONObject();
		projectDetails.put("id", project.getProjectId().toString());
		projectDetails.put("name", project.getProjectName());

		JSONArray columnJSONS = new JSONArray();
		for(Column column : project.getColumns()){
			columnJSONS.add(getColumnJSON(column));
		}

		projectDetails.put("columns", columnJSONS);
		// Add any other properties of the Project class that you want to save here.
		return projectDetails;
	}	
	
	
	public static JSONObject getColumnJSON(Column column) {
		JSONObject columnDetails = new JSONObject();
		columnDetails.put("tasks", Column.getColumnTaskList());
		columnDetails.put("name", Column.getName());

		
		JSONArray tasksJSONS = new JSONArray();
		for(Task task : column.getColumnTaskList()){
			tasksJSONS.add(getTaskJSON(task));
		}

		columnDetails.put("tasks", tasksJSONS);

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
		taskDetails.put("taskDueDate", toDateString(task.getTaskDueDate()));
		taskDetails.put("taskNotes", task.getTaskNotes());
		return taskDetails;
	}

	public static String toDateString(Date date){
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	public static void main(String[] args){
		DataWriter.saveProjects();
	}
}
