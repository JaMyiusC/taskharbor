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

	public static void saveTasks() {
		ArrayList<Task> tasks = TaskManagement.getInstance().getTaskList();
		JSONArray jsonTasks = new JSONArray();

		for(int i=0; i<tasks.size();i++) {
			jsonTasks.add(getTaskJSON(tasks.get(i)));
		}

		try(FileWriter file = new FileWriter("json/users.json")){

			file.write(jsonTasks.toJSONString());
			file.flush();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void saveColumns() {
		ArrayList<Column> columns = columnManager.getInstance().getColumnList();
		JSONArray jsonColumns = new JSONArray();
	
		for (Column column : columns) {
			jsonColumns.add(getColumnJSON(column));
		}
	
		try (FileWriter file = new FileWriter("json/columns.json")) {
			file.write(jsonColumns.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JSONObject getColumnJSON(Column column) {
		JSONObject columnDetails = new JSONObject();
		columnDetails.put("id", column.getPosition());
		columnDetails.put("name", column.getName());
		// Add any other properties of the Column class that you want to save here.
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