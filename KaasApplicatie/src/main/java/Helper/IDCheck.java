/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import MongoDao.CheeseMongoDao;
import MongoDao.ClientMongoDao;
import POJO.CheesePOJO;
import POJO.ClientPOJO;
import java.util.List;

/**
 *
 * @author Jasper Thielen
 */
public class IDCheck {
    
     
    public IDCheck(){
    }
    
    public boolean checkCheeseID(int sendID){
        
        CheeseMongoDao  cheeseMongoDAO = new CheeseMongoDao();
        
        List<CheesePOJO> list = cheeseMongoDAO.getAllCheese();
        for(CheesePOJO idsearch : list){
            int returnedid = idsearch.getCheeseID();
            System.out.println(returnedid);
            System.out.println(sendID);

            if(sendID == returnedid){
                return false;
        }
    }  
        return true;
    }
    public boolean checkClientID(int sendID){
        ClientMongoDao  clientMongoDAO = new ClientMongoDao();
        
        List<ClientPOJO> list = clientMongoDAO.getAllClient();
        for(ClientPOJO idsearch : list){
            int returnedid = idsearch.getClientID();
            System.out.println(returnedid);
            System.out.println(sendID);

            if(sendID == returnedid){
                return false;
        }
    }  
        return true;
    }
}
