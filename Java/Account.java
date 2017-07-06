
package applikaasie;

import java.util.*;

public class Account {
    
    //private final int accountNumber;
    private String accountName;
    private final String password;
    private String accountStatus;
    
    private Scanner input;
    
    public Account(){
       
        input = new Scanner(System.in);
        
                    System.out.print("please enter your account Name: ");
                    this.accountName = input.nextLine();
                    
                    //if(){} if account exists 
                    
                    System.out.print("please enter your password");
                    this.password = input.nextLine();
                    
                    //if(){} if correct
                        //System.out.println("welcome " + accountName + " " + accountNumber);
                        //acces main menu
                    
    }
}
