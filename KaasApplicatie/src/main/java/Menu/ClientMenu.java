package Menu;

import Controller.ClientController;
import java.util.*;
import java.util.logging.Logger;

public class ClientMenu {

    Logger logger = Logger.getLogger(ClientMenu.class.getName());

    private Scanner input;
    private int choice;
    private int clientID;
    private ClientController controller = new ClientController();  
    private ClientMenu menu = new ClientMenu();

    public void clientMenu() {

        logger.info("clientMenu start");

        input = new Scanner(System.in);

        System.out.print(" Client menu: " + "\n"
                + "1. New Client" + "\n"
                + "2. Remove Client" + "\n"
                + "3. Edit Client" + "\n"
                + "4. Search Client" + "\n"
                + "5. Return to last menu" + "\n"
                + "Please enter your choice: ");

        choice = input.nextInt();

        switch (choice) {
            case 1:    
                logger.info("newClient start");
        
                System.out.print("Insert Client First Name: ");
                String firstName1 = input.next();
        
                System.out.print("Insert Client Last Name: ");
                String lastName1 = input.next();
       
                System.out.print("Insert Client email");
                String eMail1 = input.next();
        
                clientID = controller.newClient(firstName1, lastName1, eMail1);
                System.out.println("New Client added with the ClientID of: " +clientID);

            menu.clientMenu();
            logger.info("newClient end");
        break;
            case 2:
                logger.info("removeClient start");
                System.out.print("Enter The clientID you want to remove: ");
                clientID = input.nextInt();
            
                System.out.println("Are You Sure you want to remove clientID: " + clientID + "  enter Yes "  );
                String anwser = input.next();
        
                controller.removeClient(clientID, anwser);
                
                logger.info("removeClient end");
                menu.clientMenu();
            
        
            
                
        break;
            case 3:
                
                logger.info("editClient start");
                System.out.println("Insert client ID to search Client: ");
                int clientID3 = input.nextInt();

                System.out.print("Insert Client First Name: ");
                String firstName3 = input.nextLine();
        
        
                System.out.print("Insert Client Last Name: ");
                String lastName3 = input.nextLine();
        
                System.out.print("Insert Client email");
                String eMail3 = input.nextLine();
                
                controller.editClient(clientID3, firstName3, lastName3, eMail3);
                logger.info("editClient end");
                menu.clientMenu();
        
                
        break;
            case 4:
                logger.info("showallClient start");        
                System.out.print("Show all clients");
               System.out.println(controller.getAllClients());
               logger.info("showallClient start");
               
               menu.clientMenu();
                
                
                
                break;
            case 5:
                logger.info("Open MainMenu");
                MainMenu mainmenu = new MainMenu();
                mainmenu.mainMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                menu.clientMenu();

        }
        logger.info("clientMenu end");
    }


}
