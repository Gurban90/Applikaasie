/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DatabaseConnector.Connector;
import Interface.AccountDAOInterface;
import POJO.AccountPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Jasper Thielen
 */
public class AccountDAO implements AccountDAOInterface {

    Logger log = Logger.getLogger(AccountDAOInterface.class.getName());
    
    private Connection connect;
    
    @Override
    public Integer addAccount(AccountPOJO account) {
        log.info("Start addAccount log");
        Integer newID = 0;
        
        String query = "INSERT INTO Account (AccountName, AccountPassword, AccountStatus) VALUES (?,?,?);";
        
        try {
            connect = Connector.getConnection();
            PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, account.getAccountName());
            statement.setString(2, account.getAccountPassword());
            statement.setInt(3, account.getAccountStatus());
            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    newID = resultSet.getInt(1);
                    account.setAccountID(newID);
                } else {
                    throw new SQLException("Creating Account failed, no ID obtained.");
                }
            }
            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("addCheese end");
        return newID;
    }

    @Override
    public List<AccountPOJO> getAllAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountPOJO getAccount(AccountPOJO account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAccount(AccountPOJO account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAccount(AccountPOJO account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}