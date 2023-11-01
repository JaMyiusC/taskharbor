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
                //existingTask.assignUser(jeffGoldblum);
                //doingColumn.addColumnTask(existingTask);
            }

            // Add a new column called "Abandoned"
            Column abandonedColumn = new Column("Abandoned");
            electricMissiles.getProjectName();

            // Move an existing task to "Abandoned"
            // Task abandonedTask = electricMissiles.getTaskName("Make impossible burger possible");
            // if (abandonedTask != null) {
            //     abandonedColumn.addColumnTask(abandonedTask);
            // }

            // Print the scrum board to a txt file
            printScrumBoardToFile(electricMissiles);
        } else {
            System.out.println("Electric Missiles project not found.");
        }
    }

    // Helper method to print the scrum board to a txt file
    // private void printScrumBoardToFile(Project project) {
    //     project.printScrumBoardToFile("scrum_board.txt");
    //     System.out.println("Scrum board printed to scrum_board.txt");
    // }

    public static void main(String[] args) {
        UI myTest = new UI();
        myTest.run();
    }
}



