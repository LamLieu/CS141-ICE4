//import java.io.*;

public class AccessPanel {

   public static void main(String[] args) {
      System.out.println("Welcome to your Access Panel.");

      //Logs user into program
      Login login = new Login();
      //Passes login info to
      Permissions actions = new Permissions(login.getUsername(), login.getPassword(), login.getStatusNumber());
      //User chooses what they want to do
      actions.chooseOption();
   }
}
