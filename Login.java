import java.util.Scanner;
import java.io.*;

public class Login {

<<<<<<< HEAD
   private User user;
   private Guest guest = new Guest();
   private Vendor vendor = new Vendor();
   private Admin admin = new Admin();
=======
   private String username, password;
   private int statusNumber;
>>>>>>> 6f02f404295fa1e21e49fcafcc556747633298b1
   private static Scanner kb = new Scanner(System.in);

   public Login() {
      System.out.println("Please enter your username and password.");
      System.out.print("Enter your Username:\n-->");
      username = kb.nextLine();
      System.out.print("Enter your Password:\n-->");
      password = kb.nextLine();

      statusNumber = checkStatus();
<<<<<<< HEAD


      switch (statusNumber) { //creates user profile
         case 1:
            if (haveAdminCode())
               if (checkAdminCode())
                  user = new Admin(username, password);
         case 2:
            user = new Vendor(username, password);
         case 3:
            user = new Guest(username, password);
=======
      while (statusNumber == 1) { //Checks if the admin has an admin code
         boolean hasAdminCode = askForAdminCode();
         if (hasAdminCode) {
            if (!checkAdminCode()) {
               statusNumber = checkStatus();
            }
            else
               break;
         }
         else  {
            System.out.println("You need to have an admin code to become an admin.");
            System.out.println("Please select a new status.");
            statusNumber = checkStatus();
         }
>>>>>>> 6f02f404295fa1e21e49fcafcc556747633298b1
      }
   }

   public int checkStatus() { //gets status of user
<<<<<<< HEAD
     int num;
      while(true){
        num = kb.nextInt();
        kb.nextLine();
        if (num != 1 || num != 2 || num != 3) {
           System.out.println("Error: Please enter 1, 2, or 3.");
           System.out.print("Are you an admin(1), vendor(2), or guest(3)?\n-->");
        }
        else
          break;
=======
      System.out.print("Are you an admin(1), vendor(2), or guest(3)?\n-->");
      int num = kb.nextInt();
      kb.nextLine();
      if (num == 1 || num == 2 || num == 3) {
         return num;
      }
      else {
         System.out.println("Error: Please enter 1, 2, or 3.");
         System.out.print("Are you an admin(1), vendor(2), or guest(3)?\n-->");
         return checkStatus();
>>>>>>> 6f02f404295fa1e21e49fcafcc556747633298b1
      }
   }

   public boolean askForAdminCode() { //asks user if he/she has an admin code
      System.out.print("Do you have an admin code?(Y/N):\n-->");
      String userYesOrNo = kb.nextLine();
      if (Character.toLowerCase(userYesOrNo.charAt(0)) == 'y') {
         return true;
      }
      else if (Character.toLowerCase(userYesOrNo.charAt(0)) == 'n') {
         return false;
      }
      else {
         System.out.println("Error: Please enter 'Y' or 'N'.");
         return askForAdminCode();
      }
   }

   public boolean checkAdminCode() { //checks user's admin code
      boolean check;
      String pass;
      System.out.print("Enter your admin code:\n-->");
<<<<<<< HEAD
      pass = kb.nextLine();
      while(true){
        check = admin.checkPass(pass); //uses method from admin class
        if (check)
           return true;
        else {
           System.out.print("Would you like to reenter your admin code?(Y/N)\n-->");
           if (Character.toLowerCase(kb.nextLine().charAt(0)) == 'y')
              checkAdminCode();
        }
=======
      check = kb.nextLine().equals("abc123"); //abc123 is the admin code.
      if (check)
         return true;
      else {
         System.out.println("Error: Invalid Admin Code.");
         return askReenterCode();
>>>>>>> 6f02f404295fa1e21e49fcafcc556747633298b1
      }
   }

   public boolean askReenterCode() {
      System.out.print("Would you like to reenter your admin code?(Y/N):\n-->");
      if (Character.toLowerCase(kb.nextLine().charAt(0)) == 'y')
         return checkAdminCode();
      else if (Character.toLowerCase(kb.nextLine().charAt(0)) == 'n')
         return false;
      else {
         System.out.println("Error: Please enter 'Y' or 'N'.");
         return askReenterCode();
      }
   }

   public String getUsername() {
      return username;
   }

   public String getPassword() {
      return password;
   }
   public int getStatusNumber() {
      return statusNumber;
   }
}
