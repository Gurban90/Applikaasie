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
   
    
    public void findAllCheese() {
        LOGGER.info("FindallCheese start");
        CheeseDAO cheesedao = new CheeseDAO();
        List<CheesePOJO> returnedCheeses = cheesedao.getAllCheese();
        System.out.println(returnedCheeses);

        LOGGER.info("FindallCheese end");
        menu = new CheeseMenu();
        menu.cheeseMenu();
    }

    public void findCheese(int ID) {
        LOGGER.info("findCheese start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO cheesepojo = new CheesePOJO();

        cheesepojo.setCheeseID(ID);
        CheesePOJO returnedcheese = cheesedao.getCheese(cheesepojo);

        System.out.println(returnedcheese);
        LOGGER.info("findCheese end");
        menu = new CheeseMenu();
        menu.cheeseMenu();
    }

    public void findCheeseWithName(String name) {
        LOGGER.info("findCheeseWithName start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO cheesepojo = new CheesePOJO();

        cheesepojo.setCheeseName(name);
        CheesePOJO returnedcheese = cheesedao.getCheeseWithName(cheesepojo);

        System.out.println(returnedcheese);
        LOGGER.info("findCheeseWithName start");
        menu = new CheeseMenu();
        menu.cheeseMenu();
    }

    public void newCheese(String name, BigDecimal price, int stock) {
        LOGGER.info("newCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        cheesepojo.setCheeseName(name);
        cheesepojo.setPrice(price);
        cheesepojo.setStock(stock);

        int CheeseID = cheesedao.addCheese(cheesepojo);
        System.out.println("Cheese is added and has ID: " + CheeseID);
        LOGGER.info("newCheese end");
        menu = new CheeseMenu();
        menu.cheeseMenu();
    }

    public void removeCheese(int ID) {
        LOGGER.info("removeCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        cheesepojo.setCheeseID(ID);
        cheesedao.deleteCheese(cheesepojo);

        LOGGER.info("removeCheese end");
        menu = new CheeseMenu();
        menu.cheeseMenu();
    }

    public void editCheese(int id, String name, BigDecimal price, int stock) {
        LOGGER.info("editCheese start");
        CheesePOJO cheesepojo = new CheesePOJO();
        CheeseDAO cheesedao = new CheeseDAO();

        cheesepojo.setCheeseID(id);
        cheesepojo.setCheeseName(name);
        cheesepojo.setPrice(price);
        cheesepojo.setStock(stock);
        cheesedao.updateCheese(cheesepojo);

        System.out.println("Cheese has been edited: ");
        LOGGER.info("editCheese end");
        menu = new CheeseMenu();
        menu.cheeseMenu();
    }

    public void editCheeseName(int id, String name) {
        LOGGER.info("editCheeseName start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO getCheese = new CheesePOJO();

        getCheese.setCheeseID(id);
        CheesePOJO cheesepojo = cheesedao.getCheese(getCheese);
        cheesepojo.setCheeseName(name);
        cheesedao.updateCheese(cheesepojo);

        System.out.println("Cheese has been edited. ");
        LOGGER.info("editCheeseName end");
        menu = new CheeseMenu();
        menu.cheeseMenu();
    }

    public void editCheesePrice(int id, BigDecimal price) {
        LOGGER.info("editCheesePrice start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO getCheese = new CheesePOJO();

        getCheese.setCheeseID(id);
        CheesePOJO cheesepojo = cheesedao.getCheese(getCheese);
        cheesepojo.setPrice(price);
        cheesedao.updateCheese(cheesepojo);

        System.out.println("Cheese has been edited: ");
        LOGGER.info("editCheesePrice end");
        menu = new CheeseMenu();
        menu.cheeseMenu();
    }

    public void editCheeseStock(int id, int stock) {
        LOGGER.info("editCheeseStock start");
        CheeseDAO cheesedao = new CheeseDAO();
        CheesePOJO getCheese = new CheesePOJO();

        getCheese.setCheeseID(id);
        CheesePOJO cheesepojo = cheesedao.getCheese(getCheese);
        cheesepojo.setStock(stock);
        cheesedao.updateCheese(cheesepojo);

        System.out.println("Cheese has been edited: ");
        LOGGER.info("editCheeseStock end");
        menu = new CheeseMenu();
        menu.cheeseMenu();
    }

}
