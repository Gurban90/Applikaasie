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
// CHEESE POJO
public class CheesePOJO {
    private int cheeseID;
    private String cheeseName;
    private BigDecimal price; 
    private int stock;
    
    
    public CheesePOJO(){};
    
    public int getCheeseID(){
	return cheeseID;
    }
    public void setCheeseID(int cheeseID) {
        this.cheeseID = cheeseID;
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
    
    
    
    
}
