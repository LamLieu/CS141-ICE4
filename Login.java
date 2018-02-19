import java.util.Scanner;
public class Login {

   private String username, password;
   private int statusNumber;
   private static Scanner kb = new Scanner(System.in);

   public Login() {
      System.out.println("Please enter your username and password.");
      System.out.print("Enter your Username:\n-->");
      username = kb.nextLine();
      System.out.print("Enter your Password:\n-->");
      password = kb.nextLine();

      statusNumber = checkStatus();
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
      }
   }

   public int checkStatus() { //gets status of user
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
      Admin admin = new Admin();
      System.out.print("Enter your admin code:\n-->");
      check = kb.nextLine().equals("abc123"); //abc123 is the admin code.
      if (check)
         return true;
      else {
         System.out.println("Error: Invalid Admin Code.");
         return askReenterCode();
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
