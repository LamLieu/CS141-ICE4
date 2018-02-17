import java.util.Scanner;
public class Permissions {
   private User user;

   public Permissions(User user){
      this.user = user;
   }

   public void action() {
      Scanner kb = new Scanner(System.in);
      int choice;
      if (user.getStatus().equals("Admin")) {
         System.out.print("What do you want to do:\n(1)Create a Vendor or Guest Account.\n" +
               "(2)Set ticket prices.\n(3)Change Password");
         choice = kb.nextInt();
         switch (choice) {

         }
      }
   }
}
