package com.csi.daotest;


import com.csi.dao.OrderDao;
import com.csi.entity.OrderDetails;
import com.csi.repo.OrderRepoImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class orderDaoImpTest {


    @Autowired
    OrderDao orderDaoImpl;

    @MockBean
    OrderRepoImpl orderRepoImpl;


    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
    Date date=null;


    @Test
    public void saveDataTest() throws ParseException {
        date=simpleDateFormat.parse("25-08-1996");
        OrderDetails orderDetails=new OrderDetails(101,"New",1236.63,date);

        orderDaoImpl.saveOrer(orderDetails);
        verify(orderRepoImpl,times(1)).save(orderDetails);
    }

    @Test
    public void findByName() throws ParseException {
        date=simpleDateFormat.parse("25-08-1996");
        String orderName=null;
        when(orderRepoImpl.findByOrderName(orderName)).thenReturn(Arrays.asList(new OrderDetails(101,"New",1236.63,date)
                ,new OrderDetails(102,"Big",1236.63,date)));


        OrderDetails orderDetail1=null;
        for(OrderDetails orderDetails:orderDaoImpl.findByOrderName(orderName)){
            orderDetail1=orderDetails;
        }

        assertEquals("Ram",orderDetail1.getOrderName());

    }

    @Test
    public void getAllData() throws ParseException {
        date=simpleDateFormat.parse("25-08-1996");
        when(orderRepoImpl.findAll()).thenReturn(Arrays.asList(new OrderDetails(101,"New",1236.63,date)
                ,new OrderDetails(102,"Big",1236.63,date)));

        assertEquals(2,orderDaoImpl.getAllOder().size());

    }

    /*@Test
    public void updateData() throws ParseException {
        date=simpleDateFormat.parse("12-12-1999");

        long orderId=0;
        OrderDetails orderDetails=orderDaoImpl.updateOrderByOrdrId(orderId);

        verify(orderRepoImpl,times(1)).save(orderDeatails);
    }*/



    }
