import java.util.Scanner;
//import java.io.*;

public class AccessPanel {
   public static Scanner kb = new Scanner(System.in);

   public static void main(String[] args) {
      User user;
      String username, password;
      int statusNumber;

      System.out.println("Welcome to your Access Panel.");

      /*
      Add a account creation system maybe?
      */

      System.out.println("Please enter your username and password.");
      System.out.print("Enter your Username:\n-->");
      username = kb.nextLine();
      System.out.print("Enter your Password:\n-->");
      password = kb.nextLine();

      System.out.print("Are you an admin(1), vendor(2), or guest(3)?\n-->");
      statusNumber = checkStatus();
      do { //Checks if the admin has an admin code
         if (haveAdminCode()) {
            if (!checkAdminCode())
               statusNumber = checkStatus();
            else break;
         }
      } while (statusNumber == 1);
      switch (statusNumber) {
         case 1:
            if (haveAdminCode()) if (checkAdminCode()) user = new Admin(username, password);
         case 2:
            user = new Vendor(username, password);
         case 3:
            user = new Guest(username, password);
      }
   }

   public static int checkStatus() {
      System.out.print("Are you an admin(1), vendor(2), or guest(3)?\n-->");
      int num = kb.nextInt();
      if (num != 1 || num != 2 || num != 3) {
         System.out.println("Error: Please enter 1, 2, or 3.");
         checkStatus();
      }
      else return num;
      return num;
   }

   public static boolean haveAdminCode() {
      System.out.println("Do you have an admin code?(Y/N)\n-->");
      String userYesOrNo = kb.nextLine();
      if (Character.toLowerCase(userYesOrNo.charAt(0)) == 'y') {
         return true;
      }
      else
         if (Character.toLowerCase(userYesOrNo.charAt(0)) == 'n') {
            return false;
         }
         else {
            System.out.println("Error: Please enter 'Y' or 'N'.");
            haveAdminCode();
         }
      return false;
   }


   public static boolean checkAdminCode() {
      boolean check;
      System.out.print("Enter your admin code:\n-->");
      check = kb.nextLine().equals("abc123"); //abc123 is the admin code.
      if (check) return true;
      else {
         System.out.print("Would you like to reenter your admin code?(Y/N)\n-->");
         if (Character.toLowerCase(kb.nextLine().charAt(0)) == 'y') checkAdminCode();
      }
      return false;
   }
}