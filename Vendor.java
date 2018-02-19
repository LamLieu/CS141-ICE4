import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Vendor extends User {

  private ArrayList<String> vendorUsers = new ArrayList<String>();

   public Vendor(String username, String password) {
      setUsername(username);
      setPassword(password);
      setVendor();
   }

   public void readGuestFile() throws IOException {
     File file = new File("guestUsers.dat");
     Scanner inputFile = new Scanner(file);
     while (inputFile.hasNext()){
     String str = inputFile.nextLine();
     vendorUsers.add(str);
     }
     inputFile.close();
   }

   public void removeVendor(String user){
     if(vendorUsers.indexOf(user) < 0){
       System.out.println("That user is not registered. Please enter the name of a registered user.");
     }
     else{
       vendorUsers.remove(vendorUsers.indexOf(user));
       System.out.println(user + " has been removed.");
     }
   }

   public void writeVendorsToFile(){
     try{
       PrintWriter outfile = new PrintWriter("VendorUsers.dat");
       for(int i = 0; i < vendorUsers.size(); i++){
         outfile.println(vendorUsers.get(i));
       }
     } catch(FileNotFoundException e){
       e.printStackTrace();
     }
   }
}
