/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDao;

import DatabaseConnector.MongoConnector;
import Interface.CheeseDAOInterface;
import POJO.CheesePOJO;
import com.mongodb.client.MongoCollection;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author Gerben
 */
public class CheeseMongoDao implements CheeseDAOInterface {

    private MongoConnector mongoConnector;
    Logger logger = Logger.getLogger(CheeseMongoDao.class.getName());

    public CheeseMongoDao() {
        mongoConnector = new MongoConnector();
    }

    private Document convertCheeseToDocument(CheesePOJO cheese) {
        Document document = new Document();
        document.append("id", cheese.getCheeseID());
        document.append("name", cheese.getCheeseName());
        document.append("price", cheese.getPrice().toPlainString());
        document.append("stock", cheese.getStock());
        return document;
    }

    @Override
    public Integer addCheese(CheesePOJO cheese) {
        logger.info("addCheese Start");
        MongoCollection<Document> collection = mongoConnector.makeConnection().getCollection("cheese");
        collection.insertOne(convertCheeseToDocument(cheese));
        mongoConnector.closeConnection();
        logger.info("addCheese end");
        return cheese.getCheeseID();

    }

    @Override
    public List<CheesePOJO> getAllCheese() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CheesePOJO getCheese(CheesePOJO cheese) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CheesePOJO getCheeseWithName(CheesePOJO cheese) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCheese(CheesePOJO cheese) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCheese(CheesePOJO cheese) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        CheesePOJO cheese1 = new CheesePOJO();
        cheese1.setCheeseID(2);
        cheese1.setCheeseName("Kaas");
        cheese1.setPrice(new BigDecimal(22));
        cheese1.setStock(2);
        CheeseMongoDao dao = new CheeseMongoDao();
        dao.addCheese(cheese1);

    }
}
