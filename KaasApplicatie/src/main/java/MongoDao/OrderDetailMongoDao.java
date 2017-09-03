/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDao;

import DatabaseConnector.MongoConnector;
import Interface.OrderDetailDAOInterface;
import POJO.OrderDetailPOJO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Sorts.orderBy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author Jasper Thielen
 */
public class OrderDetailMongoDao implements OrderDetailDAOInterface {
    
   private List<OrderDetailPOJO> orderDetail;
   private MongoCollection<Document> collection;
   private MongoCursor<Document> cursor;
   private Document doc;
   
    private MongoConnector mongoConnector;
    private Logger logger = Logger.getLogger(ClientMongoDao.class.getName());

    public OrderDetailPOJO convertDocumentToOrderDetail(Document doc) {
        OrderDetailPOJO returnOrderDetail = new OrderDetailPOJO();
        try {
            returnOrderDetail = new OrderDetailPOJO(doc.getInteger("id"),doc.getInteger("quantity"),doc.getInteger("cheeseid"),doc.getInteger("orderid"));
        } catch (NullPointerException e) {
            System.out.println("OrderDetail not found.");
        }
        return returnOrderDetail;
    }
  
    private Document convertOrderDetailToDocument(OrderDetailPOJO orderdetail) {
        doc = new Document();
        doc.append("id", orderdetail.getOrderDetailID());
        doc.append("quantity", orderdetail.getQuantity());
        doc.append("cheeseid", orderdetail.getCheeseID());
        doc.append("orderid", orderdetail.getOrderID());
        return doc;
    } 
  
  private Integer getNextId() {
        int id = 0;
        collection = mongoConnector.makeConnection().getCollection("orderdetail");
        
        if (collection.count() > 0) {
            Document highestId = collection.find().sort(orderBy(descending("id"))).first();
            id = highestId.getInteger("id") + 1;
        } else {
            id = 1;
        }
        mongoConnector.closeConnection();
        return id;
    }    
    
    
    
    @Override
    public Integer addOrderDetail(OrderDetailPOJO orderDetail) {
      logger.info("addOrderDetail Start");
        orderDetail.setOrderDetailID(getNextId());
        collection = mongoConnector.makeConnection().getCollection("orderdetail");
        collection.insertOne(convertOrderDetailToDocument(orderDetail));
        mongoConnector.closeConnection();
        logger.info("addOrderDetailt end");
        return orderDetail.getOrderDetailID();   
    }

    @Override
    public List<OrderDetailPOJO> getAllOrderDetail() {
      logger.info("getAllorderdetail Start");
        orderDetail = new ArrayList<>();
        collection = mongoConnector.makeConnection().getCollection("orderdetail");
        cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            doc = cursor.next();
            orderDetail.add(convertDocumentToOrderDetail(doc));
        }
        mongoConnector.closeConnection();
        logger.info("getAllorderdetailend");
        return orderDetail;  
    
    }

    @Override
    public List<OrderDetailPOJO> getOrderDetail(OrderDetailPOJO orderdetail) {
      logger.info("getorderdetail Start");
        orderDetail = new ArrayList<>();
        collection = mongoConnector.makeConnection().getCollection("orderdetail");
        cursor =  (MongoCursor<Document>) collection.find(eq("orderid", orderdetail.getOrderDetailID())); //heh extra test?
        while (cursor.hasNext()) {
            doc = cursor.next();
            orderDetail.add(convertDocumentToOrderDetail(doc));
        }
        mongoConnector.closeConnection();
        logger.info("getallorderdetailend");
        return orderDetail;
    }

  @Override
    public OrderDetailPOJO getOrderDetailWithID(OrderDetailPOJO orderdetail) {
        logger.info("getOrderDetailWithID Start");
        collection = mongoConnector.makeConnection().getCollection("orderdetail");
        doc = collection.find(eq("id", orderdetail.getOrderDetailID())).first();
        mongoConnector.closeConnection();
        logger.info("getOrderDetailWithID end");
        return convertDocumentToOrderDetail(doc);
    }
    
    @Override
    public void deleteOrderDetail(OrderDetailPOJO orderDetail) {
        logger.info("updateOrderDetail Start");
        collection = mongoConnector.makeConnection().getCollection("orderdetail");
        collection.findOneAndReplace(eq("id", orderDetail.getOrderDetailID()), convertOrderDetailToDocument(orderDetail));
        mongoConnector.closeConnection();
        logger.info("updateOrderDetail end");
    }

   @Override
    public void updateOrderDetail(OrderDetailPOJO orderDetail) {
       logger.info("deleteOrderDetail Start");
        collection = mongoConnector.makeConnection().getCollection("orderdetail");
        collection.findOneAndDelete(eq("id", orderDetail.getOrderDetailID()));
        mongoConnector.closeConnection();
        logger.info("deleteOrderDetail End"); 
    }
    
}
