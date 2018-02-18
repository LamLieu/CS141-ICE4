//import java.io.*;

public class AccessPanel {

   public static void main(String[] args) {
      System.out.println("Welcome to your Access Panel.");
      Login login = new Login(); //Logs user into program
      User user = login.getUser(); //Stores user profile
      Permissions actions = new Permissions(user); //Passes user profile to see what each user can do based on their status
      actions.chooseOption(); //User chooses what they want to do
      actions.endOfProgram(); //Writes all stored/changed data to files
   }
}
