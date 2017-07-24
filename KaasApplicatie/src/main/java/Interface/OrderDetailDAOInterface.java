package Interface;

import POJO.CheesePOJO;
import POJO.OrderDetailPOJO;
import POJO.OrderPOJO;
import java.util.List;

public interface OrderDetailDAOInterface {

    public Integer addOrderDetail(OrderDetailPOJO orderDetail);

    public List<OrderDetailPOJO> getAllOrderDetail();

    public List<OrderDetailPOJO> getOrderDetail(Integer orderID);

    public void updateOrderDetail(int OrderDetailID, int quantity);

    public void updateOrderDetail(int OrderDetailID, OrderPOJO order);

    public void updateOrderDetail(int OrderDetailID, CheesePOJO cheese);

    public void deleteOrderDetail(OrderDetailPOJO orderDetail);
}
