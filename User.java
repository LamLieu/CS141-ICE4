public class User { // User class is the SuperClass

   private String username, password; //Stores username and password of user
   private boolean admin = false, vendor = false, guest = false; //Sets each user's status
   private double ticketPrice = 1.0, spacePrice = 100; //Price of ticket

   public void addUser(User user) {

   }

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

   public void setPrice(double price) {
      this.ticketPrice = price;
   }

   public double getTicketPrice() {
      return ticketPrice;
   }

   public void setSpacePrice(double spacePrice) {
      this.spacePrice = spacePrice;
   }

   public double getSpacePrice() {
      return spacePrice;
   }
}
