package com.atguigu.logicalmodel.Controller;

import com.atguigu.logicalmodel.Service.OrderService;
import com.atguigu.logicalmodel.pojo.Order;
import com.atguigu.logicalmodel.pojo.Ticket;
import com.atguigu.logicalmodel.pojo.UserBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private TicketController ticketController;



    @RequestMapping("/createOrder")
    public Order commitOrder(@RequestParam("name") String name,
                                    @RequestParam("id") String id,
                                    ModelAndView mav,
                                    HttpSession session){

        // 1.从session作用域中得到用户选择的车票
        Ticket ticket = (Ticket) session.getAttribute("ticket");


        // 2.根据车票生成订单（暂时先模拟无需支付）
        UserBasic owner = (UserBasic) session.getAttribute("userBasic");
        Order order = orderService.creatOrder(owner, ticket, id, name);

        // 3.2 支付模块后续开放

        // 4.将订单存入数据库
        orderService.addOrder(order);

        return order;
    }

    @RequestMapping("/myOrder")
    public ModelAndView myOrder(ModelAndView mav,
                                HttpSession session){
        // 1.根据当前用户的id获取到他的所有订单
        UserBasic owner = (UserBasic) session.getAttribute("userBasic");
        List<Order> orders = orderService.getOrderByOwner(owner);
        // 2.将所有的订单放入session作用域
        // 目的是避免用户进行订单操作时的反复刷新导致
        // 数据库负担过重
        // 主要当发生订单修改操作时间,session作用域的订单
        // 数据也需要同步刷新

        // 返回渲染后的界面
        return null;
    }
}
