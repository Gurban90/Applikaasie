/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.CheeseDAO;
import Menu.CheeseMenu;
import POJO.CheesePOJO;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Gerben
 */
public class CheeseController {

    static final Logger LOGGER = Logger.getLogger(CheeseController.class.getName());
    private CheeseMenu menu;

    public List<CheesePOJO> findAllCheese() {
        LOGGER.info("FindallCheese start");
        CheeseDAO cheesedao = new CheeseDAO();
        LOGGER.info("FindallCheese end");
        return cheesedao.getAllCheese();
    }

    public CheesePOJO findCheese(int ID) {
        LOGGER.info("findCheese start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO cheesepojo = new CheesePOJO();

        cheesepojo.setCheeseID(ID);
        CheesePOJO returnedcheese = cheesedao.getCheese(cheesepojo);
        LOGGER.info("findCheese end");
        return returnedcheese;
    }

    public CheesePOJO findCheeseWithName(String name) {
        LOGGER.info("findCheeseWithName start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO cheesepojo = new CheesePOJO();

        cheesepojo.setCheeseName(name);
        CheesePOJO returnedcheese = cheesedao.getCheeseWithName(cheesepojo);
        LOGGER.info("findCheeseWithName end");
        return returnedcheese;
    }

    public int newCheese(String name, BigDecimal price, int stock) {
        LOGGER.info("newCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        cheesepojo.setCheeseName(name);
        cheesepojo.setPrice(price);
        cheesepojo.setStock(stock);
        LOGGER.info("newCheese end");
        return cheesedao.addCheese(cheesepojo);
    }

    public void removeCheese(int ID) {
        LOGGER.info("removeCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        cheesepojo.setCheeseID(ID);
        cheesedao.deleteCheese(cheesepojo);
        LOGGER.info("removeCheese end");
    }

    public String editCheese(int id, String name, BigDecimal price, int stock) {
        LOGGER.info("editCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        cheesepojo.setCheeseID(id);
        cheesepojo.setCheeseName(name);
        cheesepojo.setPrice(price);
        cheesepojo.setStock(stock);
        cheesedao.updateCheese(cheesepojo);
        LOGGER.info("editCheese end");
        return "Cheese has been edited: ";
    }

    public String editCheeseName(int id, String name) {
        LOGGER.info("editCheeseName start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO getCheese = new CheesePOJO();

        getCheese.setCheeseID(id);
        CheesePOJO cheesepojo = cheesedao.getCheese(getCheese);
        cheesepojo.setCheeseName(name);
        cheesedao.updateCheese(cheesepojo);
        LOGGER.info("editCheeseName end");
        return "Cheese has been edited. ";
    }

    public String editCheesePrice(int id, BigDecimal price) {
        LOGGER.info("editCheesePrice start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO getCheese = new CheesePOJO();

        getCheese.setCheeseID(id);
        CheesePOJO cheesepojo = cheesedao.getCheese(getCheese);
        cheesepojo.setPrice(price);
        cheesedao.updateCheese(cheesepojo);
        LOGGER.info("editCheesePrice end");
        return "Cheese has been edited: ";
    }

    public String editCheeseStock(int id, int stock) {
        LOGGER.info("editCheeseStock start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO getCheese = new CheesePOJO();

        getCheese.setCheeseID(id);
        CheesePOJO cheesepojo = cheesedao.getCheese(getCheese);
        cheesepojo.setStock(stock);
        cheesedao.updateCheese(cheesepojo);
        LOGGER.info("editCheeseStock end");
        return "Cheese has been edited: ";
    }

}