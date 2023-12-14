package com.atguigu.logicalmodel.Service;

import com.atguigu.logicalmodel.pojo.Order;
import com.atguigu.logicalmodel.pojo.Ticket;
import com.atguigu.logicalmodel.pojo.UserBasic;

import java.util.List;

public interface OrderService {

    int addOrder(Order order);

    List<Order> getOrderByOwner(UserBasic owner);

    Order creatOrder(UserBasic owner,Ticket ticket,String passengerId,String passengerName);
}
