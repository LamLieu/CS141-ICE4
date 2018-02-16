public class User { // User class is the SuperClass
   private String status, username, password;
   private boolean admin = false;

   public User() {
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public void setAdmin() {
      admin = true;
   }

   public String getUsername() {
      return username;
   }

   public String getStatus() {
      return status;
   }
}