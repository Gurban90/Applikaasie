/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ClientDAO;
import POJO.ClientPOJO;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Jasper Thielen
 */
public class ClientController {

    static final Logger LOGGER = Logger.getLogger(ClientController.class.getName());
    

    
    public int newClient(String firstname, String lastname, String email) {
        LOGGER.info("newClient start");

        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();
        
        clientPOJO.setFirstName(firstname);
        clientPOJO.setLastName(lastname);
        clientPOJO.setEMail(email);
        
        LOGGER.info("newClient end");
                
        return clientDAO.addClient(clientPOJO);
    
    }

    public String removeClient(int clientID, String anwser) {
       
        LOGGER.info("removeClient start");
        
        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();
        
        LOGGER.info("removeClient end");
        
        if(anwser.equals("Y")||anwser.equals("Yes")||anwser.equals("y")||anwser.equals("yes")){
        clientPOJO.setClientID(clientID);
        clientDAO.deleteClient(clientPOJO);
        return "client removed";
        
        }else{
            return "No client removed";
            
         
        }
             
    }

    public String editClient(int clientID, String firstName, String lastName, String eMail) {
        LOGGER.info("edditClient end");
        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();
        
        clientPOJO.setClientID(clientID);
        clientDAO.getClient(clientPOJO);
        
        clientPOJO.setFirstName(firstName);
        clientPOJO.setLastName(lastName);
        clientPOJO.setEMail(eMail);
        clientDAO.updateClient(clientPOJO);
        LOGGER.info("editClient end");
        return "client eddited";
    }

    public List<ClientPOJO> getAllClients() {
        
        LOGGER.info("getallClient end");
        ClientDAO clientDAO = new ClientDAO();
        LOGGER.info("getallClient end");
        return clientDAO.getAllClient();
        
          
    }

    public String editClientFirstName(int clientID, String firstName) {
        LOGGER.info("edit clientFirstName start");
        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();

        clientPOJO.setClientID(clientID);
       
        ClientPOJO searchedClient = clientDAO.getClient(clientPOJO);
        searchedClient.setFirstName(firstName);
        clientDAO.updateClient(searchedClient);
        
        clientDAO.updateClient(clientPOJO);
        LOGGER.info("editClient First Name end");
        return "Client first name has been edited. ";
    
    }

    public String editClientLastName(int clientID, String lastName) {
      LOGGER.info("edit clientFirstName start");
        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();

        clientPOJO.setClientID(clientID);
       
        ClientPOJO searchedClient = clientDAO.getClient(clientPOJO);
        searchedClient.setLastName(lastName);
        clientDAO.updateClient(searchedClient);
        
        clientDAO.updateClient(clientPOJO);
        LOGGER.info("editClient First Name end");
        return "Client first name has been edited. ";
    }

    public String editClientEMail(int clientID, String eMail) {
        LOGGER.info("edit clientemail start");
        ClientPOJO clientPOJO = new ClientPOJO();
        ClientDAO clientDAO = new ClientDAO();

        clientPOJO.setClientID(clientID);
       
        ClientPOJO searchedClient = clientDAO.getClient(clientPOJO);
        searchedClient.setEMail(eMail);
        clientDAO.updateClient(searchedClient);
        
        clientDAO.updateClient(clientPOJO);
        LOGGER.info("editClient email end");
        return "Client email has been edited. ";
    }
    
    
    
    public ClientPOJO findClientWithID(int clientID) {
          LOGGER.info("findclient with id");

        ClientDAO clientDAO = new ClientDAO();
        ClientPOJO clientPOJO = new ClientPOJO();
        
        clientPOJO.setClientID(clientID);
        
        
        ClientPOJO returnedClient = clientDAO.getClient(clientPOJO);
        LOGGER.info("findclient with id");
        return returnedClient;  
    
    }

    public List<ClientPOJO> findClientWithFirstName(String firstName) {
        LOGGER.info("findclient with first name start");

        ClientDAO clientDAO = new ClientDAO();
        
        List<ClientPOJO> returnedClient = clientDAO.getClientWithFirstName(firstName);
        LOGGER.info("findclient with first name end");
        return returnedClient;  
    
    }

    public List<ClientPOJO> findClientWithLastName(String lastName) {
        LOGGER.info("findclient with last name start");

        ClientDAO clientDAO = new ClientDAO();
        
        List<ClientPOJO> returnedClient = clientDAO.getClientWithLastName(lastName);
        LOGGER.info("findclient with last name end");
        return returnedClient;  
    
    }

    public List<ClientPOJO> findClientWithEMail(String eMail) {
      LOGGER.info("findclient with email start");

        ClientDAO clientDAO = new ClientDAO();
        
        List<ClientPOJO> returnedClient = clientDAO.getClientWithEmail(eMail);
        LOGGER.info("findclient with email end");
        return returnedClient;   
    
    }


    
}
