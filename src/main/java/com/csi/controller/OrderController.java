package com.csi.controller;


import com.csi.entity.OrderDetails;
import com.csi.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @PostMapping("/saveorder")
    public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails orderDetails){
        return new ResponseEntity<>(orderServiceImpl.saveOrer(orderDetails), HttpStatus.CREATED);
    }

    @GetMapping("/getAllOrder")
    public ResponseEntity<List<OrderDetails>> getAllOrders(){
        return new ResponseEntity<>(orderServiceImpl.getAllOder(),HttpStatus.FOUND);
    }

    @GetMapping("/getorderbyid/{orderId}")
    public ResponseEntity<OrderDetails> getOrderById(@PathVariable long orderId){
        return new ResponseEntity<>(orderServiceImpl.getOrderById(orderId),HttpStatus.FOUND);
    }

    @GetMapping("/getorderbyname/{orderName}")
    public ResponseEntity<List<OrderDetails>> getOrderByName(@PathVariable String orderName){
        return new ResponseEntity<>(orderServiceImpl.findByOrderName(orderName),HttpStatus.FOUND);
    }

    @PutMapping("/upadteorderbyid/{orderId}")
    public ResponseEntity<OrderDetails> updateOrderById(@PathVariable long orderId){
        return new ResponseEntity<>(orderServiceImpl.updateOrderByOrdrId(orderId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteorderbyid/{orderId}")
    public void deleteOrderById(@PathVariable long orderId){
      orderServiceImpl.deleteOrderByOrderId(orderId);

    }


}
