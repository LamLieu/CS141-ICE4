public class User { // User class is the SuperClass

   private String username, password;
   private boolean admin = false, vendor = false, guest = false;
   private double price = 1.0;

   public void setUsername(String username) {
      this.username = username;
   }

   public String getUsername() {
      return username;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPassword() {
      return password;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public double getPrice() {
      return price;
   }

   public void setAdmin() {
      admin = true;
   }

   public boolean isAdmin() {
      return admin;
   }

   public void setVendor() {
      vendor = true;
   }

   public boolean isVendor() {
      return vendor;
   }

   public void setGuest() {
      guest = true;
   }

   public boolean isGuest() {
      return guest;
   }

   public void addUser(User user){

   }
}