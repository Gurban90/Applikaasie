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
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Sorts.orderBy;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    private CheesePOJO convertDocumentToCheese(Document doc) {
        return new CheesePOJO(doc.getInteger("id"), doc.getString("name"), new BigDecimal(doc.getString("price")), doc.getInteger("stock"));
    }

    private Document convertCheeseToDocument(CheesePOJO cheese) {
        Document document = new Document();
        document.append("id", cheese.getCheeseID());
        document.append("name", cheese.getCheeseName());
        document.append("price", cheese.getPrice().toPlainString());
        document.append("stock", cheese.getStock());
        return document;
    }

    private Integer getNextId() {xxxxxx
        int id = 0;
        MongoCollection<Document> collection = mongoConnector.makeConnection().getCollection("cheese");
        if (collection.count() > 0) {
            Document highestId = collection.find().sort(orderBy(descending("id"))).first();<
            ---------------
            id = highestId.getInteger("id") + 1;
        } else {
            id = 1;
        }
        mongoConnector.closeConnection();
        return id;
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
        logger.info("getAllCheese Start");
        List<CheesePOJO> cheeses = new ArrayList<>();
        MongoCollection<Document> collection = mongoConnector.makeConnection().getCollection("cheese");
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            cheeses.add(convertDocumentToCheese(doc));
        }
        mongoConnector.closeConnection();
        logger.info("getAllCheese end");
        return cheeses;
    }

    @Override
    public CheesePOJO getCheese(CheesePOJO cheese) {
        logger.info("getCheese Start");
        MongoCollection<Document> collection = mongoConnector.makeConnection().getCollection("cheese");
        Document doc = collection.find(eq("id", cheese.getCheeseID())).first();
        mongoConnector.closeConnection();
        logger.info("getCheese end");
        return convertDocumentToCheese(doc);
    }

    @Override
    public CheesePOJO getCheeseWithName(CheesePOJO cheese) {
        xxxxxx logger
        .info("getCheeseWithName Start");
        MongoCollection<Document> collection = mongoConnector.makeConnection().getCollection("cheese");
        Document doc = collection.find(eq("name", cheese.getCheeseName())).first();
        mongoConnector.closeConnection();
        logger.info("getCheeseWithName end");
        return convertDocumentToCheese(doc);
    }

    @Override
    public void updateCheese(CheesePOJO cheese) {
        MongoCollection<Document> collection = mongoConnector.makeConnection().getCollection("cheese");
        collection.f collection
        .findOneAndReplace(eq("id", artikel.getId()), convertArtikelToDocument(artikel));
        mongoConnector.closeConnection();

    }

    @Override
    public void deleteCheese(CheesePOJO cheese) {
        logger.info("deleteCheese Start");
        MongoCollection<Document> collection = mongoConnector.makeConnection().getCollection("cheese");
        collection.findOneAndDelete(eq("id", cheese.getCheeseID()));
        mongoConnector.closeConnection();
        logger.info("deleteCheese Start");
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
