import java.io.FileReader;
import java.util.ArrayList;
import java.util.*;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataReader {

    public static ArrayList<User> getUsers() {
        ArrayList<User> userList = new ArrayList<>();

        try {
            FileReader reader = new FileReader("json/users.json");  // Corrected the file path
            JSONParser parser = new JSONParser();
            JSONArray userListJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < userListJSON.size(); i++) {
                JSONObject userJSON = (JSONObject) userListJSON.get(i);
                UUID id = UUID.fromString((String) userJSON.get("id"));
                String firstName = (String) userJSON.get("firstName");
                String lastName = (String) userJSON.get("lastName");
                String userName = (String) userJSON.get("userName");
                String password = (String) userJSON.get("password");
                String email = (String) userJSON.get("email");
                String phoneNumber = (String) userJSON.get("phoneNumber");
                String address = (String) userJSON.get("address");
                Role userRole = Role.valueOf((String) userJSON.get("userRole"));  // Assuming Role is an enum

                userList.add(new User(id, firstName, lastName, userName, password, email, phoneNumber, address, userRole));
            }
            return userList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Project> getProjects() {
        ArrayList<Project> projectList = new ArrayList<>();

        try {
            FileReader reader = new FileReader("projects.json");  // Corrected the file path
            JSONParser parser = new JSONParser();
            JSONArray projectListJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < projectListJSON.size(); i++) {
                JSONObject projectJSON = (JSONObject) projectListJSON.get(i);
                String projectName = (String) projectJSON.get("projectName");
                // Assuming projectDate is stored as a string, you may need to parse it accordingly
                String projectDateString = (String) projectJSON.get("projectDate");
                Date projectDate = parseDate(projectDateString);

                //projectList.add(new Project(projectName, projectDate));
            }
            return projectList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Add a method to parse Date from a string
    private Date parseDate(String dateString) {
        // Implement date parsing logic here
        // Example: SimpleDateFormat or any other date parsing method
        return null;
    }
}
