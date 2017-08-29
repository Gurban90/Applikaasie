/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDao;

import DatabaseConnector.MongoConnector;
import POJO.AddressPOJO;
import POJO.ClientPOJO;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author Gerben
 */
public class ClientMongoDao { //ALLEEN CONVERT DOC TO CLIENT
    
    private MongoConnector mongoConnector;
    Logger logger = Logger.getLogger(ClientMongoDao.class.getName());

    public ClientMongoDao() {
        mongoConnector = new MongoConnector();
    }

    public ClientPOJO convertDocumentToClient(Document doc) {
        ClientPOJO returnClient = new ClientPOJO();
        try {
            returnClient = new ClientPOJO(doc.getInteger("ClientID"), doc.getString("FirstName"), doc.getString("LastName"), doc.getString("EMail"));
        } catch (NullPointerException e) {
            System.out.println("Client not found.");
        }
        return returnClient;
    }
    
}
