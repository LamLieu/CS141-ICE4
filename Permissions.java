import java.util.Scanner;

public class Permissions {

   private User user;
   private Admin admin;
   private Guest guest;
   private Vendor vendor;

   public Permissions(String username, String password, int statusNumber) {
      switch (statusNumber) { //creates user profile
         case 1:
            user = new Admin(username, password);
            break;
         case 2:
            user = new Vendor(username, password);
            break;
         case 3:
            user = new Guest(username, password);
            break;
      }
   }

   public void chooseOption() {
      int choice;
      String name;
      Scanner kb = new Scanner(System.in);
      if (user.isAdmin()) { //Admin options
         System.out.printf("Hello %s, What do you want to do:\n(1) Create a Vendor or Guest Account.\n"
                 + "(2) Set new ticket prices.\n(3) Change Password.\n(4) Exit Program.\n-->", user.getUsername());
         choice = kb.nextInt();
         do {
            switch (choice) {
               case 1:
                  System.out.print("Which type of account would you like to create? \n(1)Create a Vendor \n(2)Guest Account.\n");
                  choice = kb.nextInt();
                  do{
                    switch (choice) {
                      case 1:
                        System.out.print("What is the guest name?");
                        name = kb.nextLine();
                        guest = new Guest(name, "abc123");
                      case 2:
                        System.out.print("What is the vendor name?");
                        name = kb.nextLine();
                        vendor = new Vendor(name, "abc123");
                      default:
                         System.out.println("Error: Please enter 1 or 2");
                         choice = kb.nextInt();
                    }
                  } while(choice != 1 && choice != 2);
                  break;
               case 2:
                  System.out.printf("The price of a ticket is currently $%.2f.\n", user.getPrice());
                  System.out.print("Would you like to set a new ticket price?(Y/N)\n-->");
                  if (Character.toLowerCase(kb.nextLine().charAt(0)) == 'y') {
                     System.out.print("Enter the new ticket price.\n-->");
                     user.setPrice(kb.nextInt());
                     System.out.printf("The new ticket price is %.2f.", user.getPrice());
                  }
                  break;
               case 3:
                  String currentPasswordInput, newPasswordInput;
                  do {
                     System.out.print("Enter your current password.\n-->");
                     currentPasswordInput = kb.nextLine();

                     if (currentPasswordInput.equals(user.getPassword())) {
                        System.out.print("Enter your new password.\n-->");
                        user.setPassword(kb.nextLine());
                        System.out.print("Confirm your new password.\n-->");
                        newPasswordInput = kb.nextLine();
                        if (newPasswordInput.equals(user.getPassword())) {
                           user.setPassword(newPasswordInput);
                           System.out.println("You have successfully changed your password!");
                        }
                        else {
                           user.setPassword(currentPasswordInput);
                           System.out.println("Error: Password does not match.");
                           System.out.println("Password has remained unchanged.");
                        }
                     }
                     else if (kb.nextLine().equals("-1")) {
                        System.exit(0);
                     }
                     else {
                        System.out.println("Error: Wrong password. Please reenter your password or type '-1' to exit");
                     }
                  } while (Integer.parseInt(currentPasswordInput) != 1 || !currentPasswordInput.equals(user.getPassword()));
                  break;
               case 4:
                  System.out.println("Thank you for using the access panel.");
                  System.exit(0);
                  break;
               default:
                  System.out.println("Error: Please enter 1, 2, 3, or 4.");
                  choice = kb.nextInt();
            }
         } while (choice < 1 || choice > 4);
         chooseOption(); //Recursive call
      }
      else if (user.isVendor()) { //Need to add permissions
         System.out.printf("Hello %s, what do you want to do:\n(1)", user.getUsername());
         //chooseOption();
      }
      else if (user.isGuest()) { //Need to add permissions
         System.out.printf("Hello %s, what do you want to do:\n(1)", user.getUsername());
         //chooseOption();
      }
   }
}
