package com.atguigu.logicalmodel.Controller;

import com.atguigu.logicalmodel.Service.StationService;
import com.atguigu.logicalmodel.Service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TravelPathController {

    @Autowired
    private StationService stationService;

    @Autowired
    private TravelService travelService;

    @RequestMapping("/consult")
    public String consult(@RequestParam("start") String start,
                          @RequestParam("destination") String destination,
                          HttpServletRequest request) {

        // 首先明确这个Controller需要向请求作用域中放入哪些信息
        // 1.起始站点，终点站点
        // 2.三种类型的车票


        if (!stationService.stationsAllExist(start, destination)) {
            request.setAttribute("msg", "访问城市不存在");
            return "consult";
        }



//        switch (type) {
//            case "最短路程":
//                return minRes(startStationId, destinationStationId, DistanceRectangle, numOfStations);
//            case "最少花费":
//                return minRes(startStationId, destinationStationId, MoneyRectangle, numOfStations);
//            case "最短时间":
//                return minRes(startStationId, destinationStationId, TimeRectangle, numOfStations);
//        }
//        return null;





        //根据要求得到特定的路线数组
        int[] pathArray = travelService.getPathArray(type, start, destination);


        // 如果不存在路线，直接返回，无需计算资源和站点信息
        if (pathArray.length == 0) {
            return "res";
        }

        // 获取各个资源的总消耗
        int totalLen = travelService.getTotalLenByPath(pathArray);
        int totalMoney = travelService.getTotalMoneyByPath(pathArray);
        int totalTime = travelService.getTotalTimeByPath(pathArray);

        // 获取经过的站点信息
        String pathStationInfo = travelService.getPathStationInfo(pathArray);


        // 将获取的信息放入请求作用域
        request.setAttribute("start", start);
        request.setAttribute("destination", destination);
        request.setAttribute("PassingPath", pathStationInfo);
        request.setAttribute("totalLen",totalLen);
        request.setAttribute("totalTime",totalTime);
        request.setAttribute("totalMoney",totalMoney);

        return "res";
    }
}
