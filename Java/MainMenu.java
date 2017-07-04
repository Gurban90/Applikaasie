/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applikaasie;

import java.util.*;

public class MainMenu {
    
    private final boolean loopmenu = true;
    private Scanner input;
    private int choice;
    
    
    public void MainMenu(){
        
        input = new Scanner(System.in);
        
        while(loopmenu){
        
        System.out.print(" Main menu: " + "\n" 
                + "1. Orders" + "\n" 
                + "2. cheeses" + "\n" 
                + "3.clients" + "\n" 
                + "4. exit" + "\n" 
                + "Please enter your choice: " );
        
        choice = input.nextInt();
        
        switch(choice){
            case 1:  //open order menu via constructor?
               break ;
            case 2: //open cheeses menu via ..?
                break;
            case 3:  //open clients menu ...?
                break;
            case 4: 
                System.out.println("goodbye...");
                System.exit(0);
            default: System.out.println("wrong number") ;
            return;
                
        }
    }
        
        
}
    
 
}
