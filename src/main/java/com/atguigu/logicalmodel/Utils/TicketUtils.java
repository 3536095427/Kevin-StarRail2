package com.atguigu.logicalmodel.Utils;

import com.atguigu.logicalmodel.pojo.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketUtils {

    private static Random random = new Random();

    // 获取需要的随机车票
    public static List<Ticket> getRandomTicketsByFactor(List<Ticket> factors,int generateNum){
        // 获取每个因子需要生成的车票数量,即膨胀因子
        int factorNum = factors.size();
        int expansionFactor = generateNum / factorNum;


        List<Ticket> tickets = new ArrayList<>(generateNum);

        for(Ticket factor : factors ){
            for(int i = 0;i < expansionFactor;i++){
                tickets.add(generateTicketByFactor(factor));
            }
        }

        // 如果数量不够，继续生成
        int leftNum = generateNum % factorNum;
        if(leftNum != 0){
            // 使用第一个因子生成缺少的车票;
            Ticket firstFactor = factors.get(0);
            for(int i = 0;i < leftNum;i++){
                tickets.add(generateTicketByFactor(firstFactor));
            }
        }

        return tickets;
    }


    private static Ticket generateTicketByFactor(Ticket factor){
        // 生成随机id;
        String randomTicketId = generateRandomTicketId();

        // 生成随机出发时间
        LocalDateTime randomStartTime = generateRandomStartTime(factor.getStartTime().toLocalDate());

        // 生成随机消耗分钟数量
        LocalTime randomSpendTime = generateRandomSpendMinutes(factor.getTime());

        int minutes = randomSpendTime.getHour() * 60 + randomSpendTime.getMinute();
        // 根据随机分钟数得到抵达时间
        LocalDateTime arrivalTime = randomStartTime.plusMinutes(minutes);

        // 生成随机价格
        int randomPrice = generateRandomPrice(factor.getPrice());

        // 生成随机距离
        int randomDistance = generateRandomDistance(factor.getDistance());

        return new Ticket(randomTicketId,
                factor.getStartStation(),factor.getDestinationStation(),
                randomStartTime,arrivalTime,
                randomDistance,randomSpendTime,randomPrice,
                factor.getPathInfo());
    }




    // 随机生成车票id
    private static String generateRandomTicketId() {
        StringBuilder randomId = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            randomId.append(random.nextInt(10)); // 生成 0 到 9 之间的随机数字
        }
        return randomId.toString();
    }


    // 随机生成出发时间
    private static LocalDateTime generateRandomStartTime(LocalDate startDate){
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        LocalTime time = LocalTime.of(hour, minute);
        return LocalDateTime.of(startDate,time);
    }

    // 随机生成消耗时间
    private static LocalTime generateRandomSpendMinutes(LocalTime factor){
        // 波动幅度（-30分钟 -- 30分钟）
        long randomNum = random.nextInt(61) - 30;

        return factor.plusMinutes(randomNum);
    }

    // 随机生成价格
    private static int generateRandomPrice(int factor){

        // 波动幅度（-20块 -- 20块）
        int randomNum = random.nextInt(41) - 20;

        return factor + randomNum;
    }

    // 随机生成距离
    private static int generateRandomDistance(int factor){

        // 波动幅度（-100km -- 100km）
        int randomNum = random.nextInt(201) - 100;

        return factor + randomNum;
    }

}
