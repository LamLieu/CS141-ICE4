//import java.io.*;

public class AccessPanel {

   public static void main(String[] args) {
      System.out.println("Welcome to your Access Panel.");
      Login userLogin = new Login(); //Logs user into program
      Permissions actions = new Permissions(userLogin.getUser()); //Passes user profile to see what each user can do based on their status
      actions.chooseOption(); //User chooses what they want to do
   }
}
