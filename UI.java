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

    public static void main(String[] args) {
        UI myTest = new UI();
        myTest.run();
    }
}



