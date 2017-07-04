package applikaasie;

import java.util.*;

public class CheeseMenu {
    
    private final boolean loopmenu = true;
    private Scanner input;
    private int choice;
    
    
    public void CheeseMenu(){
        
        input = new Scanner(System.in);
        
        while(loopmenu){
        
        System.out.print(" Main menu: " + "\n" 
                + "1. New Cheese" + "\n" 
                + "2. Remove Cheese" + "\n" 
                + "3. Edit Cheese" + "\n" 
                + "4. search Cheese" + "\n"
                + "5. return to last menu" + "\n" 
                + "Please enter your choice: " );
        
        choice = input.nextInt();
        
        switch(choice){
            case 1:
               break ;
            case 2:
                break;
            case 3: 
                break;
            case 4:  
                break;
            case 5: 
                return;
            default: System.out.println("wrong number") ;
            return;
                
        }
    }
        
        
}
    
 
}
