import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Vendor extends User {

  private ArrayList<String> vendorUsers = new ArrayList<String>();

    public Vendor(){
      readVendorFile();
    }

    public Vendor(String name){
      vendorUsers.add(name);
    }

    public Vendor(String username, String password) {
      vendorUsers.add(name);
    }

    public void addVendor(String name){
      vendorUsers.add(name);
    }

   public void readVendorFile(){
     try{
       File file = new File("guestUsers.dat");
       Scanner inputFile = new Scanner(file);
       while (inputFile.hasNext()){
         String str = inputFile.nextLine();
         vendorUsers.add(str);
       }
       inputFile.close();
     } catch(FileNotFoundException e){
         e.printStackTrace();
       }
   }

   public void removeVendor(String user){
     if(vendorUsers.indexOf(user) < 0){
       System.out.print("That user is not registered. Please enter the name of a registered user.\n-->");
     }
     else{
       vendorUsers.remove(vendorUsers.indexOf(user));
       System.out.println(user + " has been removed.");
     }
   }

   public void readVendors(){
     for(int i = 0; i < vendorUsers.size(); i++){
       System.out.println(vendorUsers.get(i));
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
