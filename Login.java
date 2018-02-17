import java.util.Scanner;
public class Login {

   private User user;
   private static Scanner kb = new Scanner(System.in);

   public Login() {
      String username, password;
      int statusNumber;
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
            else
               break;
         }
      } while (statusNumber == 1);

      switch (statusNumber) { //creates user profile
         case 1:
            if (haveAdminCode())
               if (checkAdminCode())
                  user = new Admin(username, password);
         case 2:
            user = new Vendor(username, password);
         case 3:
            user = new Guest(username, password);
      }
   }

   public int checkStatus() { //gets status of user
      int num = kb.nextInt();
      kb.nextLine();
      if (num != 1 || num != 2 || num != 3) {
         System.out.println("Error: Please enter 1, 2, or 3.");
         System.out.print("Are you an admin(1), vendor(2), or guest(3)?\n-->");
         checkStatus();
      }
      else
         return num;
      return num;
   }

   public boolean haveAdminCode() { //asks user if he/she has an admin code
      System.out.println("Do you have an admin code?(Y/N)\n-->");
      String userYesOrNo = kb.nextLine();
      if (Character.toLowerCase(userYesOrNo.charAt(0)) == 'y') {
         return true;
      }
      else if (Character.toLowerCase(userYesOrNo.charAt(0)) == 'n') {
         return false;
      }
      else {
         System.out.println("Error: Please enter 'Y' or 'N'.");
         haveAdminCode();
      }
      return false;
   }

   public boolean checkAdminCode() { //checks user's admin code
      boolean check;
      System.out.print("Enter your admin code:\n-->");
      check = kb.nextLine().equals("abc123"); //abc123 is the admin code.
      if (check)
         return true;
      else {
         System.out.print("Would you like to reenter your admin code?(Y/N)\n-->");
         if (Character.toLowerCase(kb.nextLine().charAt(0)) == 'y')
            checkAdminCode();
      }
      return false;
   }

   public User getUser() {
      return user;
   }
}
