import java.util.ArrayList;

public class Admin extends User {

   private ArrayList<String> password = new ArrayList<String>("0000");
   private ArrayList<String[]> Users = new ArrayList<String[]>();

   public Admin(String username, String password) {
      setUsername(username);
      setPassword(password);
      setAdmin();
   }

   /*
   public String toString() {
      String userInfo;
      userInfo = "Username: " + getUsername()
            + "Status: " + getStatus;
      return userInfo;
   }
   */
}
