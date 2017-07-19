/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJO.CheesePOJO;
import java.util.List;


/**
 *
 * @author Gerben
 */
public interface CheeseDAOInterface {
    
    public Integer AddCheese(CheesePOJO cheese);
    
    public List<CheesePOJO> getAllCheese();
    
    public CheesePOJO getCheese(CheesePOJO cheese);
    
    public void updateCheese(CheesePOJO cheese);
    
    public void deleteCheese (CheesePOJO cheese);
    
}
