/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import DatabaseConnector.Connector;
import DatabaseConnector.HikariConnector;
import java.sql.Connection;

/**
 *
 * @author Gerben
 */
public class ConnectionFactory {

    private HikariConnector hikari;

    public ConnectionFactory() {
        hikari = new HikariConnector();
    }

    public Connection getConnection(String connection) { ///ALLEEN INGEVOER BIJ CHEESE
        switch (connection) {
            case "jdbc":
                return Connector.getConnection();
            case "hikari":
                return hikari.getConnection();
            default:
                return hikari.getConnection();
        }
    }
}
