package com.atguigu.logicalmodel.Controller;

import com.atguigu.logicalmodel.Service.StationService;
import com.atguigu.logicalmodel.Service.TicketService;
import com.atguigu.logicalmodel.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class TravelPathController {

    @Autowired
    private StationService stationService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/consult")
    public ModelAndView returnFormOrders(ModelAndView mav){
        mav.setViewName("consult");
        return mav;
    }


    @PostMapping("/consult")
    public ModelAndView consult(@RequestParam("start") String start,
                          @RequestParam("destination") String destination,
                          @RequestParam("date") String startDate,
                          HttpSession session,
                          ModelAndView mav) {

        // 首先明确这个Controller需要向请求作用域中放入哪些信息
        //  明确的随机车票


        if (!stationService.stationsAllExist(start, destination)) {
            mav.addObject("msg", "访问城市不存在");
            mav.setViewName("consult");
            return mav;
        }

        List<Ticket> tickets = null;

        // 如果缓存中存在查询结果，直接返回
        Object attribute = session.getAttribute(start+destination);
        if (attribute instanceof List){
            tickets = (List<Ticket>) attribute;
        }else {
            Random random = new Random();
            // 车票的数量范围 5 - 10
            int ticketsNum = random.nextInt(6) + 5;
            tickets = ticketService.generateRandomTickets(LocalDate.parse(startDate), start, destination,ticketsNum );

            // 讲起点和终点的字符串组合作为键，讲查询到的车票放入缓存
            session.setAttribute(start+destination, tickets);
        }


        mav.addObject("start",start);
        mav.addObject("destination",destination);
        mav.addObject("ticketList",tickets);
        mav.setViewName("res");
        return mav;
    }
}
