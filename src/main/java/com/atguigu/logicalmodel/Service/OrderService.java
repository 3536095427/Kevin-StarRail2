package com.atguigu.logicalmodel.Service;

import com.atguigu.logicalmodel.pojo.Order;
import com.atguigu.logicalmodel.pojo.Ticket;
import com.atguigu.logicalmodel.pojo.UserBasic;
import com.sun.org.apache.xpath.internal.operations.Or;

public interface OrderService {
    int addOrder(Order order);
    Order getOrderByOwner(UserBasic owner);

    Order creatOrder(UserBasic owner,Ticket ticket,String passengerId,String passengerName);
}
