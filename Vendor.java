import java.util.ArrayList;

public class Vendor extends User {

  private ArrayList<String[]> Users = new ArrayList<String[]>();
  
   public Vendor(String username, String password) {
      setUsername(username);
      setPassword(password);
      setVendor();
   }

    public Vendor(Vendor vendor) { //Copy constructor
        setUsername(vendor.getUsername());
        setPassword(vendor.getPassword());
        setGuest();
    }
}
