package com.atguigu.logicalmodel.Controller;

import com.atguigu.logicalmodel.Service.OrderService;
import com.atguigu.logicalmodel.pojo.Order;
import com.atguigu.logicalmodel.pojo.Ticket;
import com.atguigu.logicalmodel.pojo.UserBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;


    // 创建订单
    @RequestMapping("/createOrder")
    public ModelAndView commitOrder(@RequestParam("name") String name,
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

        mav.setViewName("redirect:/myOrder");
        return mav;
    }

    // 获取当前用户的所用订单
    @RequestMapping("/myOrder")
    public ModelAndView myOrder(ModelAndView mav,
                                HttpSession session){
        // 1.根据当前用户的id获取到他的所有订单
        UserBasic owner = (UserBasic) session.getAttribute("userBasic");
        List<Order> orderList = orderService.getOrderByOwner(owner);
        


        // 2.将所有的订单放入session作用域
        // 目的是避免用户进行订单操作时的反复刷新导致
        // 数据库负担过重
        // 主要当发生订单修改操作时间,session作用域的订单
        // 数据也需要同步刷新

        session.setAttribute("orderList", orderList);

        mav.setViewName("order");
        return mav;
    }




    // 获取指定订单的详细信息
    @RequestMapping("/orderInfo")
    public ModelAndView getOrderInfo(@RequestParam("orderId") String orderId,
                              HttpSession session,
                              ModelAndView mav){

        // 根据订单Id从用户的session作用域中获取指定车票
        Order res = null;
        List<Order> orderList = (List<Order>)session.getAttribute("orderList");

        for(Order order: orderList){
            if (order.getOrderId().equals(orderId)){
                res = order;
                break;
            }
        };

        // 将获取到的订单放入请求作用域
        mav.addObject("order",res);
        mav.setViewName("orderInfo");

        return mav;
    }



    @RequestMapping("/unPaidOrderInfo")
    public ModelAndView unPaidOrderInfo(@RequestParam("orderId") String orderId,
                                     HttpSession session,
                                     ModelAndView mav){

        // 根据订单Id从用户的session作用域中获取指定车票
        Order res = null;
        List<Order> orderList = (List<Order>)session.getAttribute("orderList");

        for(Order order: orderList){
            if (order.getOrderId().equals(orderId)){
                res = order;
                break;
            }
        };

        // 将获取到的订单放入请求作用域
        mav.addObject("order",res);
        mav.setViewName("continuePay");

        return mav;
    }




    // 删除已支付订单
    @GetMapping("/deletePaidOrder")
    public ModelAndView deleteOrder(@RequestParam("orderId") String orderId,
                                    ModelAndView mav,
                                    HttpSession session){
        // 将订单从session作用域中删除
        List<Order> orderList = (List<Order>) session.getAttribute("orderList");

        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getOrderId().equals(orderId)) {
                orderList.remove(i);
                break;
            }
        }

        // 将订单从数据库中移除
        orderService.deleteOrderByOrderId(orderId);

        mav.setViewName("order");
        return mav;
    }

    // 删除未支付订单
    @GetMapping("/deleteUnPaidOrder")
    public String deleteUnPaidOrder(){
        return "forward:/deletePaidOrder";
    }


    // 继续支付订单
    @RequestMapping ("/payOrder")
    public ModelAndView payOrder(@RequestParam("orderId")String orderId,
                           ModelAndView mav,
                           HttpSession session){
        // 修改订单支付状态
        List<Order> orderList = (List<Order>) session.getAttribute("orderList");

        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                order.setPaymentStatus(1);
                break;
            }
        }

        // 将订单从数据库中移除
        orderService.payOrder(orderId);

        mav.setViewName("order");
        return mav;
    }

}
