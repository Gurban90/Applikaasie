/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDao;

import DatabaseConnector.MongoConnector;
import POJO.CheesePOJO;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Sorts.orderBy;
import java.math.BigDecimal;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author Gerben
 */
public class AccountMongoDao {
    
      private MongoConnector mongoConnector;
    Logger logger = Logger.getLogger(AccountMongoDao.class.getName());

    public AccountMongoDao() {
        mongoConnector = new MongoConnector();
    }

    private CheesePOJO convertDocumentToAccount(Document doc) {//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        CheesePOJO returnCheese = new CheesePOJO();
        try {
            returnCheese = new CheesePOJO(doc.getInteger("id"), doc.getString("name"), new BigDecimal(doc.getString("price")), doc.getInteger("stock"));
        } catch (NullPointerException e) {
            System.out.println("Must be an existing Cheese");
        }
        return returnCheese;
    }

    private Document convertAccountToDocument(CheesePOJO cheese) { //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        Document document = new Document();
        document.append("id", cheese.getCheeseID());
        document.append("name", cheese.getCheeseName());
        document.append("price", cheese.getPrice().toPlainString());
        document.append("stock", cheese.getStock());
        return document;
    }

    private Integer getNextId() {
        int id = 0;
        MongoCollection<Document> collection = mongoConnector.makeConnection().getCollection("account");
        if (collection.count() > 0) {
            Document highestId = collection.find().sort(orderBy(descending("AccountID"))).first();
            id = highestId.getInteger("AccountID") + 1;
        } else {
            id = 1;
        }
        mongoConnector.closeConnection();
        return id;
    }
    
}
