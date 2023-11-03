import java.util.ArrayList;
import java.util.Scanner;

public class UI {
	private static final String WELCOME_MESSAGE = "Welcome to our Library";
	private String[] mainMenuOptions = {"Create Account", "Login", "Projects","Checkout Item","Rate an Item","Pay a Fine","Logout"};
	private Scanner scanner;
    private UiFacade UiFacade;
	
	UI(){
		scanner = new Scanner(System.in);
        UiFacade =  new UiFacade();
	}
	
	public void run() {
		System.out.println(WELCOME_MESSAGE);
		
		//Loop as long as we want to keep interacting with the library
		while(true) {
			displayMainMenu();
			
			int userCommand = getUserCommand(mainMenuOptions.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}
			
			//if they picked the last option then log them out
			if(userCommand == mainMenuOptions.length -1) {
				UiFacade.logout();
                System.out.println("You have successfully logged out");
				break;
			}
		
			switch(userCommand) {
				case(0):
					createAccount();
					break;
				case(1):
					login();
					break;
                case(2):
                    if(UiFacade.getCurrentUser() == null) {
                        System.out.println("You must be logged in to view projects");
                    } else {
                        getProjectManager();
                        break;
                    }
			}
		}
		
		System.out.println("Good bye, and have a nice day");
		
	}
	
	private void displayMainMenu() {
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
		String password = getField("password");
		
		if(UiFacade.createAccount(firstName, lastName, userName, password)) {
			System.out.println("You have successfully created an account");
		} else {
			System.out.println("Sorry an account with that username already exists");
		}
	}
	
	private void login() {
		String userName = getField("Username");
        String password = getField("password");
		
		if(UiFacade.login(userName, password)) {
			User currentUser = UiFacade.getCurrentUser();
			System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
		} else {
			System.out.println("Sorry, invalid username ");
		}
	}
	
	private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}
	
    private ProjectManager getProjectManager() {
        System.out.println("-----Projects-----");
        ArrayList<Project> projects = UiFacade.getProjectManager().getAllProjects();

        if(projects.isEmpty()) {
            System.out.println("No projects found");
            return ProjectManager.getInstance();
        }

        for (Project project : projects) {
            System.out.println(project.getProjectName() + " " + project.getProjectDate() + " " + project.getColumns());
        }

        return ProjectManager.getInstance();
    }

	/* 
	private void checkoutItem() {
		System.out.println("\n-----Checking out an item-----");
		String item = getUserItem();
		
		if(item == null)return;
		
		if(!library.checkout(item)) {
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
		
		if(!library.rateItem(item, rating)) {
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
		
		if(!library.payFine(amount)) {
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
	}
	*/
	public static void main(String[] args) {
		UI ProjectUI= new UI();
		ProjectUI.run();
	}

}

