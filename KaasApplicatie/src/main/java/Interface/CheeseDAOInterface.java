/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJO.CheesePOJO;
import java.math.BigDecimal;
import java.util.List;


/**
 *
 * @author Gerben
 */
public interface CheeseDAOInterface {
    
    public Integer addCheese(CheesePOJO cheese);
    
    public List<CheesePOJO> getAllCheese();
    
    public CheesePOJO getCheese(CheesePOJO cheese);
    
    public CheesePOJO getCheese(String cheesename);
    
    public void updateCheese(CheesePOJO cheese);
    
    public void updateCheese(Integer CheeseID, String newName);
    
    public void updateCheese(Integer CheeseID, BigDecimal price);
    
    public void updateCheese(Integer CheeseID, Integer stock);
    
    public void deleteCheese (CheesePOJO cheese);
    
}
