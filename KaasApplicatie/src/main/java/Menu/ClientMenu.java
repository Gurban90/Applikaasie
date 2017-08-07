package Menu;

import Dao.ClientDAO;
import POJO.ClientPOJO;
import java.util.*;
import java.util.logging.Logger;

public class ClientMenu {

    Logger logger = Logger.getLogger(ClientMenu.class.getName());

    private Scanner input;
    private int choice;

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
                newClient();
                break;
            case 2:
                removeClient();
                break;
            case 3:
                editClient();
                break;
            case 4:
                searchClient();
                break;
            case 5:
                logger.info("Open MainMenu");
                MainMenu mainmenu = new MainMenu();
                mainmenu.mainMenu();
                break;
            default:
                System.out.println("wrong number, try again");
                ClientMenu clientmenu = new ClientMenu();
                clientmenu.clientMenu();

        }
        logger.info("clientMenu end");
    }

    private void newClient() {
       logger.info("newClient start");
        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();

        System.out.print("Insert Client First Name: ");
        String firstname = input.next();
        clientPOJO.setFirstName(firstname);
        
        System.out.print("Insert Client Last Name: ");
        String lastname = input.next();
        clientPOJO.setLastName(lastname);
        
        System.out.print("Insert Client email");
        String email = input.next();
        clientPOJO.setEMail(email);
        
        int clientID = clientDAO.addClient(clientPOJO);
        System.out.println("New Client added with the ClientID of: " +clientID);

        logger.info("newClient end");
        clientMenu(); 
    
    }

    private void removeClient() {
        logger.info("removeClient start");
        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();

        System.out.print("Enter The clientID you want to remove: ");
        int clientID = input.nextInt();
        
        System.out.println("Are You Sure you want to remove clientID: " + clientID + "  enter Yes "  );
        String anwser = input.next();
        
        if(anwser.equals("Y")||anwser.equals("Yes")||anwser.equals("y")||anwser.equals("yes")){
        clientPOJO.setClientID(clientID);
        clientDAO.deleteClient(clientPOJO);
        
        }
        else{
            System.out.println("Client not removed");
            removeClient();
        }


        logger.info("removeClient end");
        clientMenu();
    }

    private void editClient() {
        logger.info("editClient start");
        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();
        
        System.out.print("Tell me what to change: ");
        /*
           
        1. choose client you want to change
        2. retrieve the client
        3. alter retrieved pojo
        4. client can edit what the client wants( in this menu.
        5 send pojo.
        
        */
        
        System.out.print("Insert Client First Name: ");
        String firstname = input.next();
        clientPOJO.setFirstName(firstname);
        
        System.out.print("Insert Client Last Name: ");
        String lastname = input.next();
        clientPOJO.setLastName(lastname);
        
        System.out.print("Insert Client email");
        String email = input.next();
        clientPOJO.setEMail(email);
        
        
        clientDAO.updateClient(clientPOJO);
        

        System.out.println("Client has been edited: ");

        logger.info("editClient end");
        clientMenu();
        }

    private void searchClient() {
        logger.info("findClient start");
        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();
        
        /*needs menu choice for different searches here
            getClientWithFirstName
            getClientWithLastName
            getClientWithEmail
        
        */
        
        System.out.print("Enter ClientID : ");
        clientPOJO.setClientID(input.nextInt());
        List<ClientPOJO> clientList = clientDAO.getClient(clientPOJO);
                  
        //layout for later        
        for (ClientPOJO rippedlist : clientList){
            System.out.print(rippedlist.getClientID() +  " "
            + rippedlist.getFirstName() + " "
            + rippedlist.getLastName()  + " "
            + rippedlist.getEMail() + " /n ");
        }       

        logger.info("findClient start");
        clientMenu(); 
        }



}
