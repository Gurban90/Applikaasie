package Interface;

import POJO.CheesePOJO;
import POJO.OrderDetailPOJO;
import POJO.OrderPOJO;
import java.util.List;

public interface OrderDetailDAOInterface {

    public Integer addOrderDetail(OrderDetailPOJO orderDetail);

    public List<OrderDetailPOJO> getAllOrderDetail();

   public List<OrderDetailPOJO> getOrderDetail(OrderDetailPOJO orderdetail);
   
   public OrderDetailPOJO getOrderDetailWithID(OrderDetailPOJO orderdetail);

    public void deleteOrderDetail(OrderDetailPOJO orderDetail);
}
