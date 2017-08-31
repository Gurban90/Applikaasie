/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDao;

import Interface.OrderDAOInterface;
import POJO.ClientPOJO;
import POJO.OrderPOJO;
import java.util.List;

/**
 *
 * @author Jasper Thielen
 */
public class OrderMongoDAO implements OrderDAOInterface  {

    @Override
    public Integer addOrder(OrderPOJO order) {
        }

    @Override
    public List<OrderPOJO> getAllOrder() {
        }

    @Override
    public OrderPOJO getOrder(OrderPOJO order) {
        }

    @Override
    public List<OrderPOJO> getOrderWithClient(ClientPOJO client) {
       }

    @Override
    public void updateOrder(OrderPOJO order) {
       }

    @Override
    public void deleteOrder(OrderPOJO order) {
        }
    
}
