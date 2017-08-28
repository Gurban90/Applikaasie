/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnector;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;

/**
 *
 * @author Gerben
 */
//OM UIT TE TESTEN
public class MongoConnector {

    private String url;
    private int port;
    private String port2;
    private String database;
    private MongoClient mongoClient;

    public MongoConnector() {
        DomXML parser = new DomXML();
        url = "localhost";
        port = 27017;
        database = "KaasApplicatie";
    }

    public MongoDatabase makeConnection() {
        mongoClient = new MongoClient(url, port);
        MongoDatabase db = mongoClient.getDatabase(database);
        return db;

    }

    public void closeConnection() {
        mongoClient.close();
    }

    public static void main(String[] args) {
        MongoConnector connect = new MongoConnector();
        MongoDatabase database = connect.makeConnection();

    }

}
