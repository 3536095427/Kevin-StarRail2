package com.atguigu;

import com.atguigu.logicalmodel.Service.OrderService;
import com.atguigu.logicalmodel.Service.TicketService;
import com.atguigu.logicalmodel.Service.UserBasicService;
import com.atguigu.logicalmodel.pojo.Order;
import com.atguigu.logicalmodel.pojo.Ticket;
import com.atguigu.logicalmodel.pojo.UserBasic;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.text.resources.da.FormatData_da;

import java.time.LocalDate;
import java.util.List;


@SpringBootTest
class StarRail2ApplicationTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TicketService ticketService;

    @Test
    void test(){

        UserBasic userBasic = new UserBasic();
        userBasic.setId(1);
        userBasic.setName("三月七");
        Ticket ticket = new Ticket();
        ticket.setTicketId("55265");
        Order order = orderService.creatOrder(userBasic, ticket, "123456", "开拓者");
        System.out.println();orderService.addOrder(order);

    }

    @Test
    void test2(){
        UserBasic userBasic = new UserBasic();
        userBasic.setId(1035842);
        List<Order> orders = orderService.getOrderByOwner(userBasic);
        for(Order order: orders){
            System.out.println(order);
        }
    }

    @Test
    void test3(){
        List<Ticket> tickets = ticketService.generateRandomTickets(LocalDate.now(), "乌鲁木齐", "成都", 12);

        for (Ticket ticket : tickets){
            System.out.println(ticket);
        }
    }












//    @Autowired
//    @Qualifier("DistanceRectangle")
//    private Integer[][] DistanceRectangle;
//
//    @Autowired
//    @Qualifier("MoneyRectangle")
//    private Integer[][] MoneyRectangle;
//
//    @Autowired
//    @Qualifier("TimeRectangle")
//    private Integer[][] TimeRectangle;
//
//    @Autowired
//    @Qualifier("Retangles")
//    private HashMap<String,Integer[][]> stringHashMap;
//
//    @Test
//    @Disabled
//    void contextLoads() {
////        Integer[] dest = travelMapper.getDestinationsIdByID(1);
////        for (Integer a : dest){
////            System.out.println(a);
////        }
//    }
//
//    @Test
//    void test01(){
//        Integer[][] distanceRectangles = stringHashMap.get("DistanceRectangle");
//        Integer[][] moneyRectangles = stringHashMap.get("MoneyRectangle");
//        Integer[][] timeRectangles = stringHashMap.get("TimeRectangle");
//
//        int rows = distanceRectangles.length - 1;
//        int columns = distanceRectangles[0].length -1;
//
//        System.out.println("距离矩形：");
//        for(int i = 0;i < rows;i++){
//            for(int j = 0;j < columns;j++){
//                if(distanceRectangles[i][j] != null ){
//                    System.out.print(distanceRectangles[i][j] + " : " + this.DistanceRectangle[i][j] + " ");
//                }
//            }
//            System.out.println();
//        }
//
//        System.out.println("金钱矩形：");
//        for(int i = 0;i < rows;i++){
//            for(int j = 0;j < columns;j++){
//                if(distanceRectangles[i][j] != null ) {
//                    System.out.print(timeRectangles[i][j] + " : " + this.TimeRectangle[i][j] + " ");
//                }
//            }
//            System.out.println();
//        }
//
//        System.out.println("时间矩形：");
//        for(int i = 0;i < rows;i++){
//            for(int j = 0;j < columns;j++){
//                if(distanceRectangles[i][j] != null ) {
//                    System.out.print(moneyRectangles[i][j] + " : " + this.MoneyRectangle[i][j] + " ");
//                }
//            }
//            System.out.println();
//        }
//
//
//    }
}
