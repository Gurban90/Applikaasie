package Menu;

import Controller.ClientController;
import POJO.ClientPOJO;
import java.util.*;
import java.util.logging.Logger;

public class ClientMenu {

    Logger logger = Logger.getLogger(ClientMenu.class.getName());

    private Scanner input;
    private int choice;
    private int editChoice;
   private int searchChoice;         
    private int clientID;
    private String firstName;
    private String lastName;
    private String eMail; 
    private String anwser;
    ClientPOJO returnedClient;
    List<ClientPOJO> returnedClientList;
    
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
                firstName = input.next();
        
                System.out.print("Insert Client Last Name: ");
                lastName = input.next();
       
                System.out.print("Insert Client email");
                eMail = input.next();
        
                clientID = controller.newClient(this.firstName, this.lastName, this.eMail);
                System.out.println("New Client added with the ClientID of: " +clientID);

            menu.clientMenu();
            logger.info("newClient end");
        break;
            case 2:
                logger.info("removeClient start");
                System.out.print("Enter The clientID you want to remove: ");
                clientID = input.nextInt();
            
                System.out.println("Are You Sure you want to remove clientID: " + clientID + "  enter Yes "  );
                anwser = input.next();
        
                controller.removeClient(clientID, anwser);
                
                logger.info("removeClient end");
                menu.clientMenu();
                           
                break;
            case 3:
                editClientMenu();               
                break;
        
            case 4:
                searchClientMenu();
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


   public void editClientMenu(){
      
       System.out.print(" Client menu: " + "\n"
                + "1. Show all clients" + "\n"
                + "2. Alter first Name" + "\n"
                + "3. Alter last Name" + "\n"
                + "4. alter email" + "\n"
                + "5. edit all" + "\n"
                + "6. Return to last menu" + "\n"
                + "Please enter your choice: ");

         editChoice = input.nextInt(); 
         
         switch (editChoice) {
            
             case 1:
               logger.info("showallClient start");        
               System.out.print("Show all clients");
               controller = new ClientController();
               System.out.println(controller.getAllClients());
               logger.info("showallClient start");
               
                menu = new ClientMenu();
                menu.clientMenu();
                break;
            case 2:
                System.out.print("Insert ClientID: ");
                this.clientID = input.nextInt();
                System.out.print("Insert new First Name: ");
                this.firstName = input.nextLine();

                controller = new ClientController();
                System.out.println(controller.editClientFirstName(clientID, firstName));
                menu = new ClientMenu();
                menu.clientMenu();
                break;
            case 3:
                System.out.print("Insert ClientID: ");
                this.clientID = input.nextInt();
                System.out.print("Insert last Name: ");
                this.lastName = input.nextLine();

                controller = new ClientController();
                System.out.println(controller.editClientLastName(clientID, lastName));
                menu = new ClientMenu();
                menu.clientMenu();
                break;
            case 4:
                System.out.print("Insert ClientID: ");
                this.clientID = input.nextInt();
                System.out.print("Insert eMail: ");
                this.lastName = input.nextLine();

                controller = new ClientController();
                System.out.println(controller.editClientEMail(clientID, eMail));
                menu = new ClientMenu();
                menu.clientMenu();
                break;
            
            case 5:
               logger.info("editClient start");
                System.out.println("Insert client ID to search Client: ");
                this.clientID = input.nextInt();   
                System.out.print("Insert Client First Name: ");
                this.firstName = input.nextLine();
                System.out.print("Insert Client Last Name: ");
                this.lastName = input.nextLine();
                System.out.print("Insert Client email");
                this.eMail = input.nextLine();
                
                controller.editClient(clientID, this.firstName, this.lastName, this.eMail);
                logger.info("editClient end");
                menu = new ClientMenu();
                menu.clientMenu();
                break;
            case 6:
                menu = new ClientMenu();
                menu.clientMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                editClientMenu();
        }
        logger.info("editclientMenu end");
    
       
   }
   
   public void searchClientMenu(){
       
       System.out.print(" Client menu: " + "\n"
                + "1. Show all clients" + "\n"
                + "2. Search on ID" + "\n"
                + "3. Search on firstName" + "\n"
                + "4 Search on lastName" + "\n"
                + "5 search on eMail" + "\n"
                + "5. Return to last menu" + "\n"
                + "Please enter your choice: ");
       
       searchChoice = input.nextInt();
       
    switch (searchChoice){
       
        case 1:
               logger.info("showallClient start");        
               System.out.print("Show all clients");
               controller = new ClientController();
               System.out.println(controller.getAllClients());
               logger.info("showallClient start");
               
                menu = new ClientMenu();
                menu.clientMenu();
                break;
         case 2:
                System.out.print("clientID please: ");
                this.clientID = input.nextInt();

                controller = new ClientController();
                this.returnedClient = controller.findClientWithID(clientID);
                System.out.println(returnedClient);
               
                menu = new ClientMenu();
                menu.clientMenu();
                break;
         case 3:
                System.out.print("firstName please: ");
                this.firstName = input.next();

                controller = new ClientController();
                this.returnedClientList = controller.findClientWithFirstName(firstName);
                
               for(ClientPOJO printList : returnedClientList){
                   System.out.println(printList.getClientID());
                   System.out.println(printList.getFirstName());
                   System.out.println(printList.getLastName());
                   System.out.println(printList.getEMail());
                   
               }
                
                
               
                menu = new ClientMenu();
                menu.clientMenu();
                break;
         case 4:
               System.out.print("lastName please: ");
                this.lastName = input.next();

                controller = new ClientController();
                 this.returnedClientList = controller.findClientWithLastName(lastName);
                
                 for(ClientPOJO printList : returnedClientList){
                   System.out.println(printList.getClientID());
                   System.out.println(printList.getFirstName());
                   System.out.println(printList.getLastName());
                   System.out.println(printList.getEMail());
                   
               }
               
                menu = new ClientMenu();
                menu.clientMenu();
                break;
         case 5:
              System.out.print("eMail please: ");
                this.firstName = input.next();

                controller = new ClientController();
                this.returnedClientList = controller.findClientWithEMail(eMail);
                
                for(ClientPOJO printList : returnedClientList){
                   System.out.println(printList.getClientID());
                   System.out.println(printList.getFirstName());
                   System.out.println(printList.getLastName());
                   System.out.println(printList.getEMail());
                   
               }
               
                menu = new ClientMenu();
                menu.clientMenu();
                break;
        case 6:
                menu = new ClientMenu();
                menu.clientMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                editClientMenu();
        }
   }
}
