package com.csi.dao;


import com.csi.entity.OrderDetails;
import com.csi.exception.OrderNotFoundException;
import com.csi.repo.OrderRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrderRepoImpl orderRepoImpl;

    @Override
    public OrderDetails saveOrer(OrderDetails orderDetails) {
        return orderRepoImpl.save(orderDetails);
    }

    @Override
    public List<OrderDetails> getAllOder() {
        return orderRepoImpl.findAll();
    }

    @Override
    public OrderDetails getOrderById(long orderId) {
        return orderRepoImpl.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order is Not available with this id!!!!!!!!!!"));
    }

    @Override
    public List<OrderDetails> findByOrderName(String orderName) {
        return orderRepoImpl.findByOrderName(orderName);
    }

    @Override
    public OrderDetails updateOrderByOrdrId(long orderId) {

        OrderDetails order=orderRepoImpl.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order is Not available with this id!!!!!!!!!!"));
        OrderDetails order1=new OrderDetails();
        order1.setOrderName(order.getOrderName());
        order1.setOrderValue(order.getOrderValue());
        order1.setOrderDate(order.getOrderDate());
        return orderRepoImpl.save(order1);
    }

    @Override
    public void deleteOrderByOrderId(long orderId) {
        OrderDetails order=orderRepoImpl.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order is Not available with this id!!!!!!!!!!"));

        orderRepoImpl.deleteById(orderId);


    }
}
