package Interface;

import POJO.OrderDetailPOJO;
import java.util.List;

public interface OrderDetailDAOInterface {
    
    public Integer addOrder(OrderDetailPOJO orderD);
    
    public List<OrderDetailPOJO> getAllDetailOrder();
    
    public OrderDetailPOJO getOrder(OrderDetailPOJO orderD);
    
    public void updateOrderDetail(OrderDetailPOJO orderD);
    
    public boolean deleteOrderDetail (OrderDetailPOJO orderD);
}