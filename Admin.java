public class Admin extends User {

   public Admin(String username, String password) {
      setUsername(username);
      setPassword(password);
      setStatus("Admin");
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
