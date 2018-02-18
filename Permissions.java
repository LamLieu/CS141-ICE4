import java.util.Scanner;
import java.io.*;

public class Permissions { //May want to change class name

   private User user;
   private Admin admin;
   private Guest guest;
   private Vendor vendor;

   public Permissions(User user) {
      this.user = user;
   }

   public void chooseOption() {
      Scanner kb = new Scanner(System.in);
      int choice;
      String name;
      if (user.isAdmin()) { //Admin options
         System.out.print("What do you want to do:\n(1)Create a Vendor or Guest Account.\n" +
               "(2)Set new ticket prices.\n(3)Change Password.\n(4)Exit Program.");
         do {
            choice = kb.nextInt();
            switch (choice) {
               case 1: //Need to add account creation
                  System.out.print("Which type of account would you like to create? \n(1)Create a Vendor \n(2)Guest Account.\n");
                  choice = kb.nextInt();
                  do{
                    switch (choice) {
                      case 1:
                        System.out.print("What is the guest name?\n-->");
                        name = kb.nextLine();
                        guest = new Guest(name);
                        break;
                      case 2:
                        System.out.print("What is the vendor name?\n-->");
                        name = kb.nextLine();
                        vendor = new Vendor(name);
                        break;
                      default:
                         System.out.println("Error: Please enter 1 or 2\n-->");
                    }
                  } while(choice != 1 || choice != 2);
                  break;
               case 2:
                  System.out.printf("The price of a ticket is currently $%.2f.\n", user.getPrice());
                  System.out.print("Would you like to set a new ticket price?(Y/N)\n-->");
                  if (Character.toLowerCase(kb.nextLine().charAt(0)) == 'y') {
                     System.out.print("Enter the new ticket price.\n-->");
                     user.setPrice(kb.nextInt());
                  }
                  break;
               case 3:
                  String currentPasswordInput;
                  do {
                     System.out.print("Enter your current password.\n-->");
                     currentPasswordInput = kb.nextLine();
                     if (kb.nextLine().equals(user.getPassword())) {
                        System.out.print("Enter your new password.\n-->");
                        user.setPassword(kb.nextLine());
                     }
                     else {
                        System.out.println("Error: Wrong password. Please reenter your password or type '-1' to exit");
                     }
                  } while (Integer.parseInt(currentPasswordInput) != 1 || !currentPasswordInput.equals(user.getPassword()));
                  break;
               case 4:
                  System.out.println("Thank you for using the access panel.");
                  System.exit(0);
               default:
                  System.out.println("Error: Please enter 1, 2, 3, or 4.");
            }
         } while (choice < 1 || choice > 4);
      }
      else if (user.isVendor()) { //Need to add permissions
        do{
          System.out.print("Would you like to \n(1)Remove yourself from the list of vendors\n(2)View the number of guests");
          choice = kb.nextInt();
          switch (choice) {
            case 1:
              System.out.print("What is the guest name?\n-->");
              name = kb.nextLine();
              guest = new Guest(name);
              break;
            case 2:
              System.out.print("What is the vendor name?\n-->");
              name = kb.nextLine();
              vendor = new Vendor(name);
              break;
            default:
               System.out.print("Error: Please enter 1 or 2\n-->");
          }
        } while(choice != 1 || choice != 2);
      }
      else if (user.isGuest()) { //Need to add permissions
        guest = new Guest();
        vendor = new Vendor();
        do{
          System.out.println("Would you like to \n(1)Refund your tickets\n(2)View the vendors");
          choice = kb.nextInt();
          switch (choice) {
            case 1:
              System.out.print("What is your username?\n-->");
              name = kb.nextLine();
              guest.removeGuest(name);
              break;
            case 2:
              System.out.println("Here are the vendors:");
              vendor.readVendors();
              break;
            default:
               System.out.print("Error: Please enter 1 or 2\n-->");
          }
        } while(choice != 1 || choice != 2);
      }
   }

   public void endOfProgram(){
     guest = new Guest();
     vendor = new Vendor();
     admin = new Admin();

     guest.writeGuestsToFile();
     vendor.writeVendorsToFile();
     admin.writeAdminsToFile();
   }
}
