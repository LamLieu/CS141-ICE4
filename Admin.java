import java.util.ArrayList;

public class Admin extends User {

   private ArrayList<String> password = new ArrayList<String>();
   private ArrayList<String[]> Users = new ArrayList<String[]>();

   public Admin(String username, String password) {
      setUsername(username);
      setPassword(password);
      setAdmin();
   }

    public Admin(Admin admin) { //Copy constructor
        setUsername(admin.getUsername());
        setPassword(admin.getPassword());
        setGuest();
    }

  public void addPassword(String pass){
       password.add(pass);
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
