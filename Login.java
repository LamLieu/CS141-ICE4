import java.util.Scanner;
import java.io.*;

public class Login {

   private User user;
   private Guest guest = new Guest();
   private Vendor vendor = new Vendor();
   private Admin admin = new Admin();
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
      }
      return num;
   }

   public boolean haveAdminCode() { //asks user if he/she has an admin code
      System.out.println("Do you have an admin code?(Y/N)\n-->");
      while(true){
        String userYesOrNo = kb.nextLine();
        if (Character.toLowerCase(userYesOrNo.charAt(0)) == 'y') {
           return true;
        }
        else if (Character.toLowerCase(userYesOrNo.charAt(0)) == 'n') {
           return false;
        }
        else {
           System.out.println("Error: Please enter 'Y' or 'N'.");
        }
      }
   }

   public boolean checkAdminCode() { //checks user's admin code
      boolean check;
      String pass;
      System.out.print("Enter your admin code:\n-->");
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
      }
   }

   public User getUser() {
      return user;
   }
}
