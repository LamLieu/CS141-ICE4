//import java.io.*;

public class AccessPanel {

   public static void main(String[] args) {
      System.out.println("Welcome to your Access Panel.");
      Login login = new Login();
      User user = login.getUser();
      Permissions actions = new Permissions(user); //Should probably change variable name
      actions.chooseOption();
   }
}