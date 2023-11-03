/** 
import java.util.ArrayList;

public class UI {

    public void run() {
        scenario3();
    }

    public void scenario1() {
        ArrayList<User> users = DataReader.getUsers();
        for(User user : users){
            System.out.println(user);
        }
    }

    public void scenario2(){
        DataWriter.saveUsers();
    }

    public void scenario3() {
        UiFacade facade = new UiFacade();
        facade.addUser("Jenny", "Smith", "....", null, null, null, null, null);
        facade.login("jsmith", "12345");

        System.out.println(facade.getCurrentUser());

        facade.logout();
    }

    public void scenario5() {

        // Open Electric Missiles project
        Project electricMissiles = ProjectManager.getInstance().getProjectByName("Electric Missiles");
        if (electricMissiles != null) {
            // Add a new task
            Task newTask = new Task();
            User jeffGoldblum = UserManagement.getInstance().getUser("jeffgoldblum", "password");
            newTask.assignUser(jeffGoldblum);
           // electricMissiles.getTaskNotes(newTask);

            // Add a comment to the task
           // newTask.addComment("Avoid civilians Jeff!");

            // Move an existing task to 'Doing' column
            String doingColumn = electricMissiles.getProjectName();
           // Task existingTask = electricMissiles.getTaskName("Curve the metal to make a cylindrical shape");
            comments existingTask = electricMissiles.getTaskByName("Curve the metal to make a cylindrical shape");
            if (doingColumn != null && existingTask != null) {
                existingTask.removeComment("Not cylindrical enough");
                existingTask.removeComment("What's a cylinder");
                existingTask.addComment("How about you do it Jeff");
                existingTask.assignUser(jeffGoldblum);
                doingColumn.addColumnTask(existingTask);
            }

            // Add a new column called "Abandoned"
            Column abandonedColumn = new Column("Abandoned");
            electricMissiles.getProjectName();

            Move an existing task to "Abandoned"
            Task abandonedTask = electricMissiles.getTaskName("Make impossible burger possible");
            if (abandonedTask != null) {
                abandonedColumn.addColumnTask(abandonedTask);
            }

            // Print the scrum board to a txt file
            printScrumBoardToFile(electricMissiles);
        } else {
            System.out.println("Electric Missiles project not found.");
        }
    }

    Helper method to print the scrum board to a txt file
    private void printScrumBoardToFile(Project project) {
        project.printScrumBoardToFile("scrum_board.txt");
        System.out.println("Scrum board printed to scrum_board.txt");
    }

    public static void main(String[] args) {
        UI myTest = new UI();
        myTest.run();
    }
}
*/
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static final String WELCOME_MESSAGE = "Welcome to taskharbor !";
    private String[] mainMenuOptions = {"Create Account", "Login", "Find Item","Checkout Item","Rate an Item","Pay a Fine","Logout"};
    private Scanner scanner;
    private UiFacade scenario;
    private ProjectManager projectManager;
    private TaskManagement taskManagement;
    ArrayList<comments> commentsList = new ArrayList<>();
    
    UI(){
        scanner = new Scanner(System.in);
        projectManager = ProjectManager.getInstance();
        taskManagement = TaskManagement.getInstance();
        scenario = new UiFacade();
    }
    
    public void run() {
        System.out.println(WELCOME_MESSAGE);

        while (true) {
            displayMainMenu();

            int userCommand = getUserCommand(mainMenuOptions.length);

            if (userCommand == -1) {
                System.out.println("Not a valid command");
                continue;
            }

            if (userCommand == mainMenuOptions.length - 1) {
                break; // Exit the program
            }
        
            switch (userCommand) {
                case 0:
                    viewChangeHistory();
                    break;
                case 1:
                    addTask();
                    break;
                case 2:
                    viewProjects();
                    break;
            }
        }

            /*switch(userCommand) {
                case(0):
                    createAccount();
                    break;
                case(1):
                    login();
                    break;
                case(2):
                    findItem();
                    break;
                case(3):
                    checkoutItem();
                    break;
                case(4):
                    rateItem();
                    break;
                case(5):
                    payFine();
                    break;
            }
        }*/
        
        System.out.println("Good bye, and have a nice day");
        
    }
    private void displayMainMenu() {
        System.out.println("\n************ Main Menu *************");
        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println((i + 1) + ". " + mainMenuOptions[i]);
        }
        System.out.println("\n");
    }

    private int getUserCommand(int numCommands) {
        System.out.print("Select an option: ");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command <= numCommands - 1) return command;

        return -1;
    }

    private void viewChangeHistory() {
        System.out.println("\n-----Change History-----");
        ArrayList<String> taskHistory = changeHistory.getInstance().viewTaskHistory();
        if (taskHistory.isEmpty()) {
            System.out.println("Change history is empty.");
        } else {
            for (String historyEntry : taskHistory) {
                System.out.println(historyEntry);
            }
        }
    }

    private void addTask() {
        System.out.println("\n-----Add a Task-----");
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter task priority: ");
        int taskPriority = Integer.parseInt(scanner.nextLine());
ArrayList<comments> commentsList = new ArrayList<>();
        Task task = new Task("Task Name", 1, null, "Task Notes", commentsList);
        taskManagement.addTask(task);
        System.out.println("Task added successfully!");
    }

    private void viewProjects() {
        System.out.println("\n-----Projects-----");
        ArrayList<Project> projects = projectManager.getProject();
        if (projects.isEmpty()) {
            System.out.println("No projects available.");
        } else {
            for (int i = 0; i < projects.size(); i++) {
                Project project = projects.get(i);
                System.out.println("Project " + (i + 1));
                System.out.println("Name: " + project.getProjectName());
                // Print other project details here
                System.out.println();
            }
        }
    }
    /*private void displayMainMenu() {
        System.out.println("\n************ Main Menu *************");
        for(int i=0; i< mainMenuOptions.length; i++) {
            System.out.println((i+1) + ". " + mainMenuOptions[i]);
        }
        System.out.println("\n");
    }
    
    //get the users command number, if it's not valid, return -1
    private int getUserCommand(int numCommands) {
        System.out.print("What would you like to do?: ");
        
        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;
        
        if(command >= 0 && command <= numCommands -1) return command;
        
        return -1;
    }
    
    private void createAccount() {
        String userName = getField("Username");
        String firstName = getField("First Name");
        String lastName = getField("Last Name");
        int age = Integer.parseInt(getField("Age"));
        String phoneNumber = getField("Phone Number");
        
        if(scenario.createAccount(userName, firstName, lastName, age, phoneNumber)) {
            System.out.println("You have successfully created an account");
        } else {
            System.out.println("Sorry an account with that username already exists");
        }
    }
    
    private void login() {
        String userName = getField("Username");
        
        if(scenario.login(userName)) {
            User currentUser = scenario.getCurrentUser();
            System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }
    
    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
    
    private void findItem() {
        System.out.println("\n-----Searching the Library-----");
        String item = getUserItem();
        
        if(item == null)return;
        
        if(!scenario.findItem(item)) {
            System.out.println("Sorry we couldn't find your item\n");
            return;
        }
        
        System.out.println("YAY your item is in the library\n");        
    }
    
    private void checkoutItem() {
        System.out.println("\n-----Checking out an item-----");
        String item = getUserItem();
        
        if(item == null)return;
        
        if(!scenario.checkout(item)) {
            System.out.println("Sorry we couldn't checkout your item\n");
            return;
        }
        System.out.println("Your item was successfully checked out\n");
    }
    
    private void rateItem() {
        System.out.println("\n-----Searching the Library-----");
        String item = getUserItem();
        
        if(item == null)return;
        
        //get rating
        System.out.print("Enter rating: ");
        int rating = Integer.parseInt(scanner.nextLine());
        
        if(rating < 0 || rating > 5) {
            System.out.println("Not a valid rating\n");
            return;
        }
        
        if(!scenario.rateItem(item, rating)) {
            System.out.println("Sorry we couldn't rate your item\n");
            return;
        }
        
        System.out.println("Item was successfully rated\n");
    }
    
    private void payFine() {
        System.out.println("-----Paying a fine-----");
        
        //get amount
        System.out.print("Enter amount: ");
        int amount = Integer.parseInt(scanner.nextLine());
        
        if(amount < 0) {
            System.out.println("Not a valid amount\n");
            return;
        }
        
        if(!scenario.payFine(amount)) {
            System.out.println("Sorry, you were not able to pay this fine.\n");
            return;
        }
        
        System.out.println("Fine paid\n");
    }
    
    private String getUserItem() {
        System.out.print("Enter Item Name: ");
        
        while(true) {
            String itemName = scanner.nextLine().trim().toLowerCase();
        
            if(!itemName.contentEquals("")) return itemName;
            
            System.out.println("You need to actually enter content");
            System.out.print("Would you like to enter item again (y) or return to main menu (n): ");
            String command = scanner.nextLine().trim().toLowerCase();
            if(command == "n") return null;
        }
    }*/
    
    
    public static void main(String[] args) {
        UiFacade scenarioInterface = new UiFacade();
        scenarioInterface.run();

    }

}



