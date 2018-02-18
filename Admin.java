import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Admin extends User {

   private ArrayList<String> password = new ArrayList<String>();
   private ArrayList<String> adminUsers = new ArrayList<String>();

   public Admin(){
     password.add(0, "0000");
     adminUsers.add(0, "admin");
     readAdminFile();
   }

   public Admin(String name){
     adminUsers.add(name);
   }

   public Admin(String username, String password) {
      setUsername(username);
      setPassword(password);
      setAdmin();
   }

   public void addPassword(String pass){
     password.add(pass);
   }

   public void readAdminFile() throws IOException{
     File file = new File("adminUsers.dat");
     Scanner inputFile = new Scanner(file);
     while (inputFile.hasNext()){
       String str = inputFile.nextLine();
       adminUsers.add(str);
     }
     inputFile.close();
   }

   public void removeAdmin(String user){
     if(adminUsers.indexOf(user) < 0){
       System.out.print("That user is not registered. Please enter the name of a registered user.\n-->");
     }
     else{
       adminUsers.remove(adminUsers.indexOf(user));
       System.out.println(user + " has been removed.");
     }
   }

   public boolean checkPass(String pass){
     boolean check = false;
     for(int i = 0; i < adminUsers.size(); i++){
       if(adminUsers.get(i).equals(pass)){
        check = true;
        break;
      }
     }
     return check;
   }

   public void writeAdminsToFile(){
     try{
       PrintWriter outfile = new PrintWriter("adminUsers.dat");
       for(int i = 0; i < adminUsers.size(); i++){
         outfile.println(adminUsers.get(i));
       }
     } catch(FileNotFoundException e){
       e.printStackTrace();
     }
   }

  /*
  public String toString() {
  String userInfo;
  userInfo = "Username: " + getUsername()
  + "Status: " + getStatus;
  return userInfo;
  }
  */
}
