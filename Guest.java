public class Guest extends User {
   public Guest(String username, String password) {
      setUsername(username);
      setPassword(password);
      setStatus("Vendor");
   }
}
