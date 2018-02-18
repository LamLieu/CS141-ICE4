import java.util.Scanner;

public class Permissions {

   private User user;

   public Permissions(User userProfile) {
      this.user = userProfile;
   }

   public void chooseOption() {
      int choice;
      Scanner kb = new Scanner(System.in);
      if (user.isAdmin()) { //Admin options
         System.out.print("What do you want to do:\n(1)Create a Vendor or Guest Account.\n" +
               "(2)Set new ticket prices.\n(3)Change Password.\n(4)Exit Program.");
         choice = kb.nextInt();
         do {
            switch (choice) {
               case 1: //Need to add account creation
                  ;
               case 2:
                  System.out.printf("The price of a ticket is currently $%.2f.\n", user.getPrice());
                  System.out.print("Would you like to set a new ticket price?(Y/N)\n-->");
                  if (Character.toLowerCase(kb.nextLine().charAt(0)) == 'y') {
                     System.out.print("Enter the new ticket price.\n-->");
                     user.setPrice(kb.nextInt());
                  }
               case 3:
                  String currentPasswordInput, newPasswordInput;
                  do {
                     System.out.print("Enter your current password.\n-->");
                     currentPasswordInput = kb.nextLine();

                     if (kb.nextLine().equals(user.getPassword())) {
                        System.out.print("Enter your new password.\n-->");
                        user.setPassword(kb.nextLine());
                        System.out.print("Confirm your new password.\n-->");
                        newPasswordInput = kb.nextLine();
                        if (newPasswordInput.equals(user.getPassword()))
                           System.out.println("You have successfully changed your password!");
                        else {
                           System.out.println("Error: New password does not match.");
                           System.out.println("Reverting back to old password.");
                           user.setPassword(currentPasswordInput);
                        }
                        System.out.println("You have successfully changed your password!");
                     }
                     else if (kb.nextLine().equals("-1")) {
                        System.exit(0);
                     }
                     else {
                        System.out.println("Error: Wrong password. Please reenter your password or type '-1' to exit");
                     }
                  } while (Integer.parseInt(currentPasswordInput) != 1 || !currentPasswordInput.equals(user.getPassword()));
               case 4:
                  System.out.println("Thank you for using the access panel.");
                  System.exit(0);
               default:
                  System.out.println("Error: Please enter 1, 2, 3, or 4.");
                  choice = kb.nextInt();
            }
         } while (choice < 1 || choice > 4);
         chooseOption(); //Keep asking user for actions
      }
      else if (user.isVendor()) { //Need to add permissions
         System.exit(0); //Temp
         //chooseOption();
      }
      else if (user.isGuest()) { //Need to add permissions
         System.exit(0); //Temp
         //chooseOption();
      }
   }
}
