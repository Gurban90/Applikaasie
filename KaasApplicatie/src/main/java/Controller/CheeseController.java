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

    Logger logger = Logger.getLogger(CheeseController.class.getName());
    CheeseMenu menu = new CheeseMenu();

    public void findAllCheese() {
        logger.info("FindallCheese start");
        CheeseDAO cheesedao = new CheeseDAO();
        List<CheesePOJO> returnedCheeses = cheesedao.getAllCheese();
        System.out.println(returnedCheeses);

        logger.info("FindallCheese end");
        menu.cheeseMenu();
    }

    public void findCheese(int ID) {
        logger.info("findCheese start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO cheesepojo = new CheesePOJO();

        cheesepojo.setCheeseID(ID);
        CheesePOJO returnedcheese = cheesedao.getCheese(cheesepojo);

        System.out.println(returnedcheese);
        logger.info("findCheese end");
        menu.cheeseMenu();
    }

    public void findCheeseWithName(String name) {
        logger.info("findCheeseWithName start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO cheesepojo = new CheesePOJO();

        cheesepojo.setCheeseName(name);
        CheesePOJO returnedcheese = cheesedao.getCheeseWithName(cheesepojo);

        System.out.println(returnedcheese);
        logger.info("findCheeseWithName start");
        menu.cheeseMenu();
    }

    public void newCheese(String name, BigDecimal price, int stock) {
        logger.info("newCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        cheesepojo.setCheeseName(name);
        cheesepojo.setPrice(price);
        cheesepojo.setStock(stock);

        int CheeseID = cheesedao.addCheese(cheesepojo);
        System.out.println("Cheese is added and has ID: " + CheeseID);
        logger.info("newCheese end");
        menu.cheeseMenu();
    }

    public void removeCheese(int ID) {
        logger.info("removeCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        cheesepojo.setCheeseID(ID);
        cheesedao.deleteCheese(cheesepojo);

        logger.info("removeCheese end");
        menu.cheeseMenu();
    }

    public void editCheese(int id, String name, BigDecimal price, int stock) {
        logger.info("editCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        cheesepojo.setCheeseID(id);
        cheesepojo.setCheeseName(name);
        cheesepojo.setPrice(price);
        cheesepojo.setStock(stock);
        cheesedao.updateCheese(cheesepojo);

        System.out.println("Cheese has been edited: ");
        logger.info("editCheese end");
        menu.cheeseMenu();
    }

    public void editCheeseName(int id, String name) {
        logger.info("editCheeseName start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO getCheese = new CheesePOJO();

        getCheese.setCheeseID(id);
        CheesePOJO cheesepojo = cheesedao.getCheese(getCheese);
        cheesepojo.setCheeseName(name);
        cheesedao.updateCheese(cheesepojo);

        System.out.println("Cheese has been edited. ");
        logger.info("editCheeseName end");
        menu.cheeseMenu();
    }

    public void editCheesePrice(int id, BigDecimal price) {
        logger.info("editCheesePrice start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO getCheese = new CheesePOJO();

        getCheese.setCheeseID(id);
        CheesePOJO cheesepojo = cheesedao.getCheese(getCheese);
        cheesepojo.setPrice(price);
        cheesedao.updateCheese(cheesepojo);

        System.out.println("Cheese has been edited: ");
        logger.info("editCheesePrice end");
        menu.cheeseMenu();
    }

    public void editCheeseStock(int id, int stock) {
        logger.info("editCheeseStock start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO getCheese = new CheesePOJO();

        getCheese.setCheeseID(id);
        CheesePOJO cheesepojo = cheesedao.getCheese(getCheese);
        cheesepojo.setStock(stock);
        cheesedao.updateCheese(cheesepojo);

        System.out.println("Cheese has been edited: ");
        logger.info("editCheeseStock end");
        menu.cheeseMenu();
    }

}
