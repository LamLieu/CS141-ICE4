import java.io.*;
import java.util.Scanner;

public class AccessPanel {
  private User user;
  private Guest guest = new Guest();
  private Vendor vendor = new Vendor();
  private Admin admin = new Admin();
  private static Scanner kb = new Scanner(System.in);

  public static void Login() {
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

  public static int checkStatus() { //gets status of user
    int num;
     while(true){
       num = kb.nextInt();
       kb.nextLine();
       if (num == 1 || num == 2 || num == 3) {
          break;
       }
       else {
         System.out.println("Error: Please enter 1, 2, or 3.");
         System.out.print("Are you an admin(1), vendor(2), or guest(3)?\n-->");
       }
     }
    return num;
  }

  public static boolean haveAdminCode() { //asks user if he/she has an admin code
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

  public static boolean checkAdminCode() { //checks user's admin code
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

   public static void main(String[] args) {
      System.out.println("Welcome to your Access Panel.");
      //Login login = new Login(); //Logs user into program
      //User user = login.getUser(); //Stores user profile
      login();
      //Permissions actions = new Permissions(user); //Passes user profile to see what each user can do based on their status
      actions.chooseOption(); //User chooses what they want to do
      actions.endOfProgram(); //Writes all stored/changed data to files
   }
}
