package com.csi.dao;

import com.csi.entity.OrderDetails;

import java.util.List;

public interface OrderDao {

    public OrderDetails saveOrer(OrderDetails orderDetails);

    public List<OrderDetails> getAllOder();

    public OrderDetails getOrderById(long orderId);

    public List<OrderDetails> findByOrderName(String OrderName);

    public OrderDetails updateOrderByOrdrId(long OrderId);

    public void deleteOrderByOrderId(long OrderId);
}
