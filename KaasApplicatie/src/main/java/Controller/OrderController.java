/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.OrderDAO;
import Dao.OrderDetailDAO;
import Interface.OrderDAOInterface;
import Interface.OrderDetailDAOInterface;
import POJO.CheesePOJO;
import POJO.ClientPOJO;
import POJO.OrderDetailPOJO;
import POJO.OrderPOJO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Jasper Thielen
 */
public class OrderController {

    Integer orderID;
    Integer orderDetailID;
    private OrderDAOInterface orderdao;
    private OrderPOJO orderpojo;
    private OrderDetailPOJO orderdetailpojo;
    private OrderDetailDAOInterface orderdetaildao;

    //Voor test
    public OrderController(OrderDAOInterface orderdao, OrderDetailDAOInterface orderdetaildao) {
        this.orderdao = orderdao;
        this.orderpojo = new OrderPOJO();
        this.orderdetailpojo = new OrderDetailPOJO();
        this.orderdetaildao = orderdetaildao;
    }

    public OrderController() {
        this.orderdao = new OrderDAO();
        this.orderdetaildao = new OrderDetailDAO();
        this.orderpojo = new OrderPOJO();
        this.orderdetailpojo = new OrderDetailPOJO();
    }

    public Integer setOrder(LocalDateTime orderDate, BigDecimal totalPrice, LocalDateTime processedDate, int ClientID) {
        orderpojo.setOrderDate(orderDate);
        orderpojo.setProcessedDate(processedDate);
        orderpojo.setTotalPrice(totalPrice);
        orderpojo.setClientID(ClientID);
        orderID = orderdao.addOrder(orderpojo);
        return orderID;
    }

    public Integer setOrderDetail(int quantity, int orderID, int cheeseID) {
        orderdetailpojo.setQuantity(quantity);
        orderdetailpojo.setOrderID(orderID);
        orderdetailpojo.setCheeseID(cheeseID);
        orderDetailID = orderdetaildao.addOrderDetail(orderdetailpojo);
        return orderDetailID;
    }

    public String removeOrder(int orderID) {
        orderpojo.setOrderID(orderID);
        orderdao.deleteOrder(orderpojo);
        return "order removed. ";
    }

    public String removeOrderDetail(int orderDetailID) {
        orderdetailpojo.setOrderDetailID(orderDetailID);
        orderdetaildao.deleteOrderDetail(orderdetailpojo);
        return "orderDetail removed. ";
    }

    public List<OrderDetailPOJO> searchOrderDetail(int orderID) {
        orderdetailpojo.setOrderID(orderID);
        List<OrderDetailPOJO> returnedOrderDetail = orderdetaildao.getOrderDetail(orderdetailpojo);
        return returnedOrderDetail;
    }

    public List<OrderPOJO> getAllOrders() {
        return orderdao.getAllOrder();
    }

    public OrderPOJO searchOrder(int orderID) {
        orderpojo.setOrderID(orderID);
        OrderPOJO returnedOrder = orderdao.getOrder(orderpojo);
        return returnedOrder;
    }

    public void editOrderTime(int orderID, LocalDateTime x) {
        orderpojo.setOrderID(orderID);
        orderpojo = orderdao.getOrder(orderpojo);
        orderpojo.setOrderDate(x);
        orderdao.updateOrder(orderpojo);
    }

    public void editOrderDeliverTime(int orderID, LocalDateTime x) {
        orderpojo.setOrderID(orderID);
        orderpojo = orderdao.getOrder(orderpojo);
        orderpojo.setProcessedDate(x);
        orderdao.updateOrder(orderpojo);
    }

    public String editOrderDetailCheese(int orderDetailID, int cheeseID) {
        orderdetailpojo.setOrderDetailID(orderDetailID);
        orderdetailpojo = orderdetaildao.getOrderDetailWithID(orderdetailpojo);
        orderdetailpojo.setCheeseID(cheeseID);
        orderdetaildao.updateOrderDetail(orderdetailpojo);
        return "orderdetail cheese editted";
    }

    public String editOrderDetailAmmount(int orderDetailID, int cheeseAmmount) {
        orderdetailpojo.setOrderDetailID(orderDetailID);
        orderdetailpojo = orderdetaildao.getOrderDetailWithID(orderdetailpojo);
        orderdetailpojo.setQuantity(cheeseAmmount);
        orderdetaildao.updateOrderDetail(orderdetailpojo);
        return "orderdetailammount eddited";
    }

}
