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
    
}
