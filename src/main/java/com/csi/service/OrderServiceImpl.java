package com.csi.service;

import com.csi.dao.OrderDao;
import com.csi.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl {

    @Autowired
    OrderDao orderDaoImpl;


    public OrderDetails saveOrer(OrderDetails orderDetails) {
        return orderDaoImpl.saveOrer(orderDetails);
    }


    public List<OrderDetails> getAllOder() {
        return orderDaoImpl.getAllOder();
    }


    public OrderDetails getOrderById(long orderId) {
        return orderDaoImpl.getOrderById(orderId);    }


    public List<OrderDetails> findByOrderName(String orderName) {
        return orderDaoImpl.findByOrderName(orderName);
    }


    public OrderDetails updateOrderByOrdrId(long orderId) {


        return orderDaoImpl.updateOrderByOrdrId(orderId);
    }


    public void deleteOrderByOrderId(long orderId) {
        orderDaoImpl.deleteOrderByOrderId(orderId);


    }


}
