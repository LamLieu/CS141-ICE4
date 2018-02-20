import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Guest extends User {

  private ArrayList<String> guestUsers = new ArrayList<String>();

    public Guest(){
      readGuestFile();
    }

    public Guest(String name){
      guestUsers.add(name);
    }

   public Guest(String username, String password) {
      guestUsers.add(username);
   }

   public void addGuest(String name){
     guestUsers.add(name);
   }

   public int numGuest(){
     int guests;
     guests = guestUsers.size();
     return guests;
   }

   public void readGuestFile(){
     try{
       File file = new File("guestUsers.dat");
       Scanner inputFile = new Scanner(file);
       while (inputFile.hasNext()){
         String str = inputFile.nextLine();
         guestUsers.add(str);
       }
       inputFile.close();
     } catch(FileNotFoundException e){
       e.printStackTrace();
     }
   }

   public void removeGuest(String user){
     if(guestUsers.indexOf(user) < 0){
       System.out.print("That user is not registered. Please enter the name of a registered user.\n-->");
     }
     else{
       guestUsers.remove(guestUsers.indexOf(user));
       System.out.println(user + " has been removed.");
     }
   }

   public void writeGuestsToFile(){
     try{
       PrintWriter outfile = new PrintWriter("guestUsers.dat");
       for(int i = 0; i < guestUsers.size(); i++){
         outfile.println(guestUsers.get(i));
       }
     } catch(FileNotFoundException e){
       e.printStackTrace();
     }
   }
}
