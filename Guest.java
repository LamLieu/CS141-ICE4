import java.util.ArrayList;

public class Guest extends User {

  private ArrayList<String[]> Users = new ArrayList<String[]>();

   public Guest(String username, String password) {
      setUsername(username);
      setPassword(password);
      setGuest();
   }

   public Guest(Guest guest) { //Copy constructor
   setUsername(guest.getUsername());
   setPassword(guest.getPassword());
   setGuest();
   }
}
