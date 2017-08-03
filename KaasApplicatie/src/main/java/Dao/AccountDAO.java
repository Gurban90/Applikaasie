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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Jasper Thielen & Gerben
 */
public class AccountDAO implements AccountDAOInterface {

    Logger logger = Logger.getLogger(AccountDAOInterface.class.getName());

    private Connection connection;

    @Override
    public Integer addAccount(AccountPOJO account) {
        logger.info("Start addAccount log");
        Integer newID = 0;

        String query = "INSERT INTO Account (AccountName, AccountPassword, AccountStatus) VALUES (?,?,?);";

        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        logger.info("addAccount end");
        return newID;
    }

    @Override
    public List<AccountPOJO> getAllAccount() {
        logger.info("getAllAccount Start");
        String query = "SELECT * FROM Account;";
        List<AccountPOJO> returnedAccounts = new ArrayList<>();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AccountPOJO account = new AccountPOJO();
                account.setAccountID(resultSet.getInt(1));
                account.setAccountName(resultSet.getString(2));
                account.setAccountPassword(resultSet.getString(3));
                account.setAccountStatus(resultSet.getInt(4));
                returnedAccounts.add(account);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("getAllAccount end");
        return returnedAccounts;
    }

    @Override
    public AccountPOJO getAccount(AccountPOJO account) {
        logger.info("getAccount Start");
        String query = "SELECT * FROM Account WHERE AccountID=?";
        AccountPOJO foundaccount = new AccountPOJO();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, account.getAccountID());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                foundaccount.setAccountID(resultSet.getInt(1));
                foundaccount.setAccountName(resultSet.getString(2));
                foundaccount.setAccountPassword(resultSet.getString(3));
                foundaccount.setAccountStatus(resultSet.getInt(4));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("getAccount end");
        return foundaccount;
    }

    @Override
    public List<AccountPOJO> getAccountWithName(AccountPOJO account) {
        logger.info("getAccountWithName Start");
        String query = "SELECT * FROM Account WHERE AccountName=?";
        List<AccountPOJO> returnedAccounts = new ArrayList<>();
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, account.getAccountName());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AccountPOJO accountpojo = new AccountPOJO();
                accountpojo.setAccountID(resultSet.getInt(1));
                accountpojo.setAccountName(resultSet.getString(2));
                accountpojo.setAccountPassword(resultSet.getString(3));
                accountpojo.setAccountStatus(resultSet.getInt(4));
                returnedAccounts.add(accountpojo);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("getAccountWithName end");
        return returnedAccounts;
    }

    @Override
    public void updateAccount(AccountPOJO account) {
        logger.info("updateAccount Start");
        String query = "UPDATE Account SET AccountName = ?, AccountPassword = ?, AccountStatus = ? WHERE AccountID=?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, account.getAccountName());
            statement.setString(2, account.getAccountPassword());
            statement.setInt(3, account.getAccountStatus());
            statement.setInt(4, account.getAccountID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("updateAccount end");
    }

    @Override
    public void deleteAccount(AccountPOJO account) {
        logger.info("deleteAccount Start");
        String query = "DELETE FROM Account WHERE AccountID = ?";
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, account.getAccountID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("deleteAccount end");
    }

}
