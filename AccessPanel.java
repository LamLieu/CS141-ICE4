//import java.io.*;

public class AccessPanel {

   public static void main(String[] args) {
      User user;
      Login login = new Login();
      user = login.getUser();
      Permissions actions = new Permissions(user);
      actions.action();
   }
}