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

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/commitOrder")
    public Order commitOrder(@RequestParam("name") String name,
                                    @RequestParam("id") String id,
                                    ModelAndView mav,
                                    HttpSession session){
        // 生成新的订单
        Ticket ticket = (Ticket) session.getAttribute("ticket");
        UserBasic owner = (UserBasic) session.getAttribute("userBasic");
        Order order = orderService.creatOrder(owner, ticket, id, name);




        return order;
    }
}
