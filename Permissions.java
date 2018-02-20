import java.util.Scanner;
import java.io.*;

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

   public void chooseOption() throws IOException {
      int choice;
      String name;
      Scanner kb = new Scanner(System.in);
      char userAnswer;

      //Admin Options
      if (user.isAdmin()) {
         System.out.printf("Hello %s, What do you want to do:\n(1) Create a Vendor or Guest Account.\n"
               + "(2) Set new ticket prices.\n(3) Set new space price.\n"
               + "(4) Change Password.\n(5) Remove an account.\n "
               + "(6)View registered users\n(7) Exit Program.\n-->", user.getUsername());
         choice = kb.nextInt();
         do {
            switch (choice) {
               case 1:
                  System.out.print("Which type of account would you like to create?\n(1) Create a Vendor\n"
                        + "(2) Guest Account.\n-->");
                  choice = kb.nextInt();
                  do {
                     switch (choice) {
                        case 1:
                           System.out.print("What is the guest name?\n-->");
                           name = kb.nextLine();
                           guest = new Guest(name, "abc123");
                           guest.writeGuestsToFile();
                           break;
                        case 2:
                           System.out.print("What is the vendor name?\n-->");
                           name = kb.nextLine();
                           vendor = new Vendor(name, "abc123");
                           vendor.writeVendorsToFile();
                           break;
                        default:
                           System.out.println("Error: Invalid input.");
                           choice = kb.nextInt();
                     }
                  } while (choice != 1 && choice != 2);
                  break;
               case 2:
                  System.out.printf("The price of a ticket is currently $%.2f.\n", user.getTicketPrice());
                  System.out.print("Would you like to set a new ticket price?(Y/N)\n-->");
                  userAnswer = Character.toLowerCase(kb.next().charAt(0));
                  if (userAnswer == 'y') {
                     System.out.print("Enter the new ticket price.\n-->");
                     user.setPrice(kb.nextInt());
                     System.out.printf("The new ticket price is %.2f.", user.getTicketPrice());
                  }
                  else if (userAnswer == 'n') {
                     System.out.println("The price of the space remains the same.");
                  }
                  else {
                     System.out.println("Error: Invalid response.");
                  }
                  break;
               case 3:
                  System.out.printf("The price of a space is currently $%.2f.\n", user.getSpacePrice());
                  System.out.print("Would you like to set a new space price?(Y/N)\n-->");
                  userAnswer = Character.toLowerCase(kb.next().charAt(0));
                  if (userAnswer == 'y') {
                     System.out.print("Enter the new space price.\n-->");
                     user.setSpacePrice(kb.nextInt());
                     System.out.printf("The new ticket price is %.2f.", user.getSpacePrice());
                  }
                  else if (userAnswer == 'n') {
                     System.out.println("The price of the space remains the same.");
                  }
                  else {
                     System.out.println("Error: Invalid input.");
                  }
                  break;
               case 4:
                  String currentPasswordInput, newPasswordInput;
                  do {
                     System.out.print("Enter your current password. (or -1 to go back to menu)\n-->");
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
                        break;
                     }
                     else {
                        System.out.println("Error: Wrong password.\n" + "Please reenter your password or type '-1' to return to menu.");
                     }
                  } while (!currentPasswordInput.equals(user.getPassword()) || !currentPasswordInput.equals("-1"));
                  break;
               case 5:
                  System.out.print("Which account would you like to remove? \n(1) Guest Account\n"
                        + "(2) Vendor Account.\n-->");
                  choice = kb.nextInt();
                  do {
                     switch (choice) {
                        case 1:
                           System.out.print("What is the guest name?\n-->");
                           name = kb.nextLine();
                           guest.removeGuest(name);
                           guest.writeGuestsToFile();
                           break;
                        case 2:
                           System.out.print("What is the vendor name?\n-->");
                           name = kb.nextLine();
                           vendor.removeVendor(name);
                           vendor.writeVendorsToFile();
                           break;
                        default:
                           System.out.println("Error: Invalid input.");
                           choice = kb.nextInt();
                     }
                  } while (choice != 1 && choice != 2);
                  break;
               case 6:
                  System.out.print("Which accounts would you like to view?\n(1) Guest Account\n"
                        + "(2) Vendor Account.\n-->");
                  choice = kb.nextInt();
                  do {
                     switch (choice) {
                        case 1:
                           guest.readGuestFile();
                           break;
                        case 2:
                           vendor.readVendorFile();
                           break;
                        default:
                           System.out.println("Error: Invalid input.");
                           choice = kb.nextInt();
                     }
                  } while (choice != 1 && choice != 2);
                  break;
               case 7:
                  System.out.println("Thank you for using the access panel.");
                  System.exit(0);
               default:
                  System.out.println("Error: Please enter 1, 2, 3, 4, 5, 6, or 7.");
            }
         } while (choice < 1 || choice > 7);
         System.out.println("Returning back to menu...");
         chooseOption();
      }

      //Vendor Options
      else if (user.isVendor()) {
         System.out.printf("Hello %s, what do you want to do:\n(1) Purchase space.\n"
               + "(2) Exit Program.", user.getUsername());
         choice = kb.nextInt();
         do {
            switch (choice) {
               case 1:
                  System.out.printf("The price of a spot is $%.2f.", user.getSpacePrice());
                  System.out.print("Would you like to set a new space price?(Y/N)\n-->");
                  userAnswer = Character.toLowerCase(kb.next().charAt(0));
                  if (userAnswer == 'y') {
                     System.out.println("Thank you for purchasing a ticket.");
                  }
                  else if (userAnswer == 'n') {
                     break;
                  }
                  else {
                     System.out.println("Error: Invalid input.");
                  }
                  chooseOption();
                  break;
               case 2:
                  System.out.println("Thank you for using the access panel.");
                  System.exit(0);
            }
         } while (choice < 1 || choice > 2);
         System.out.println("Returning back to menu...");
         chooseOption();
      }

      //Guest Options
      else if (user.isGuest()) { //Need to add permissions
         System.out.printf("Hello %s, what do you want to do:\n(1) Purchase ticket.\n"
               + "(2) Exit Program.", user.getUsername());
         choice = kb.nextInt();
         do {
            switch (choice) {
               case 1:
                  System.out.printf("The ticket price is $%.2f.", user.getTicketPrice());
                  System.out.print("Would you like to set a new space price?(Y/N)\n-->");
                  userAnswer = Character.toLowerCase(kb.nextLine().charAt(0));
                  if (userAnswer == 'y') {
                     System.out.println("Thank you for purchasing a ticket.");
                     System.out.println("Returning back to menu...");
                  }
                  else if (userAnswer == 'n') {
                     break;
                  }
                  else {
                     System.out.println("Error: Invalid input.");
                  }
                  break;
               case 2:
                  System.out.println("Thank you for using the access panel.");
                  System.exit(0);
            }
         } while (choice < 1 || choice > 2);
         System.out.println("Returning back to menu...");
         chooseOption();
      }
   }
}
