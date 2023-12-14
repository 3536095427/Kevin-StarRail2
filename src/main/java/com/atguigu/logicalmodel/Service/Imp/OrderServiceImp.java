package com.atguigu.logicalmodel.Service.Imp;

import com.atguigu.logicalmodel.Mapper.OrderMapper;
import com.atguigu.logicalmodel.Service.OrderService;
import com.atguigu.logicalmodel.pojo.Order;
import com.atguigu.logicalmodel.pojo.Ticket;
import com.atguigu.logicalmodel.pojo.UserBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public List<Order> getOrderByOwner(UserBasic owner) {
        return orderMapper.getOrderByOwnerID(owner.getId());
    }

    @Override
    public Order creatOrder(UserBasic owner,Ticket ticket, String passengerId, String passengerName) {

        Random random = new Random();
        StringBuilder orderId = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            orderId.append(random.nextInt(10)); // 生成 0 到 9 之间的随机数字
        }

        LocalDateTime now = LocalDateTime.now();

        return new Order(orderId.toString(),owner,passengerName,passengerId,now,0,ticket);
    }
}
