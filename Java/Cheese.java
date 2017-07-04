/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSvier;

import java.math.BigDecimal;

/**
 *
 * @author Gerben
 */
//OPZET CHEESE CLASS
public class Cheese {
    private int cheeseNumber;
    private String cheeseName;
    private BigDecimal price; 
    private int stock;
    
    
    public Cheese(){};
    
    public int getCheeseNumber(){
	return cheeseNumber;
    }
    public void setCheeseNumber(int cheeseNumber) {
        this.cheeseNumber = cheeseNumber;
    }


    public String getCheeseName() {
	return cheeseName;
    }
    public void setCheeseName(String cheeseName) {
	this.cheeseName = cheeseName;
    }


    public BigDecimal getPrice() {
	return price;
    }
    public void setPrice(BigDecimal price) {
	this.price = price;
    }

    public int getStock() {
	return stock;
    }
    public void setStock(int stock) {
	this.stock = stock;
    }
    
    
    public void removeCheese(){
        //DELETE Cheese FROM DATABASE
    }
    
    @Override
    public String toString(){
	return "Cheese Number: " + cheeseNumber + ". Cheese Data: " + cheeseName + " " + price + " " + stock; 
    }
}
