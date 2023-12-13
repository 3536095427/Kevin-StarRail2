package com.atguigu.logicalmodel.Controller;

import com.atguigu.logicalmodel.Mapper.TicketMapper;
import com.atguigu.logicalmodel.Service.TicketService;
import com.atguigu.logicalmodel.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/buyTicket")
    public ModelAndView buyTicket(@RequestParam("ticketId") String tickeId,
                                  @RequestParam("startStation") String start,
                                  @RequestParam("destinationStation") String destination,
                                  ModelAndView mav,
                                  HttpSession session){

        // 从缓存中获取车票列表
        List<Ticket> tickets = (List<Ticket>)session.getAttribute(start+destination);

        Ticket ticket = null;
        for(Ticket t : tickets){
            if (t.getTicketId().equals(tickeId)){
                ticket = t;
                break;
            }
        }

        session.setAttribute("ticket", ticket);
        mav.setViewName("buyTicket");
        return mav;
    }

}
