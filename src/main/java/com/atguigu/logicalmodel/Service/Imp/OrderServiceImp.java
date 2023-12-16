package com.atguigu.logicalmodel.Service.Imp;

import cn.hutool.core.util.RandomUtil;
import com.atguigu.logicalmodel.Mapper.OrderMapper;
import com.atguigu.logicalmodel.Service.OrderService;
import com.atguigu.logicalmodel.pojo.Order;
import com.atguigu.logicalmodel.pojo.Ticket;
import com.atguigu.logicalmodel.pojo.UserBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        return orderMapper.getOrderByOwnerId(owner.getId());
    }

    @Override
    public Order creatOrder(UserBasic owner,Ticket ticket, String passengerId, String passengerName) {

        // 随机订单ID
        String orderId = RandomUtil.randomNumbers(10);
        // 获取订单生成时间
        LocalDateTime now = LocalDateTime.now();

        return new Order(orderId,owner,passengerName,passengerId,now,0,ticket);
    }

    @Override
    public boolean deleteOrderByOrderId(String orderId) {
        int res = orderMapper.deleteOrderByOrderId(orderId);
        return res != 0;
    }

    @Override
    public boolean payOrder(String orderId) {
        int res = orderMapper.payOrder(orderId);
        return res != 0;
    }
}
