package com.atguigu.logicalmodel.Controller;


import com.atguigu.logicalmodel.Service.UserBasicService;
import com.atguigu.logicalmodel.pojo.Station;
import com.atguigu.logicalmodel.pojo.UserBasic;
import com.atguigu.logicalmodel.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userBasicService")
    private UserBasicService userBasicService;

    @Autowired
    @Qualifier("allStationsKeyName")
    private HashMap<String, Station> stationsKeyName;

    @Autowired
    @Qualifier("allStationsKeyId")
    private HashMap<Integer, Station> stationsKeyId;

    @Autowired
    @Qualifier("DistanceRectangle")
    private Integer[][] DistanceRectangle;

    @Autowired
    @Qualifier("MoneyRectangle")
    private Integer[][] MoneyRectangle;

    @Autowired
    @Qualifier("TimeRectangle")
    private Integer[][] TimeRectangle;

    private int[] pathArray;

    @GetMapping(value = {"/", "/index"})
    public String login() {
        return "login";
    }


    @RequestMapping("/login")
    public String login(@RequestParam("loginId") Integer loginId,
                        @RequestParam("password") String password,
                        HttpServletRequest request) {
        UserBasic userBasic = userBasicService.Login(loginId, password);

        if (userBasic == null) {
            System.out.println("登陆失败");
            return "login";
        } else {

            //将用户的具体信息从数据库导入
            userBasic.setUserDetail(userBasicService.getUserDetailById(userBasic.getId()));

            request.getSession().setAttribute("userBasic", userBasic);
            System.out.println("登陆成功");
            return "index";
        }
    }

    @RequestMapping("/userInfo")
    public String userInfo() {
        return "Info";
    }

    @RequestMapping("/consult")
    public String consult(@RequestParam("start") String start,
                          @RequestParam("destination") String destination,
                          @RequestParam("type") String type,
                          HttpServletRequest request) {
        int numOfStations = stationsKeyName.size();

        //获取始发站,终点站编号
        Station stationBegin = stationsKeyName.get(start);
        Station stationGoal = stationsKeyName.get(destination);

        if (stationBegin == null || stationGoal == null) {
            request.setAttribute("msg", "访问城市不存在");
            return "index";
        }

        Integer startNum = stationBegin.getId();
        Integer destinationNum = stationGoal.getId();

        //根据要求得到特定的路线数组
        pathArray = getPathArray(type, startNum, destinationNum, numOfStations);
        if (pathArray.length != 0) {
            int arrayLen = pathArray.length - 1;
            //存储各个阶段资源消耗
            Integer[] len = new Integer[arrayLen];
            Integer[] money = new Integer[arrayLen];
            Integer[] time = new Integer[arrayLen];

            CalculatorResource(arrayLen, request, len, money, time);
            setPathInfo(arrayLen, request, len, money, time);
        }

        return "res";
    }

    //获取存储路过站点编号的数组
    private int[] getPathArray(String type, int startNum, int destinationNum, int numOfStations) {

        switch (type) {
            case "最短路程":
                return userBasicService.minRes(startNum, destinationNum, DistanceRectangle, numOfStations);
            case "最少花费":
                return userBasicService.minRes(startNum, destinationNum, MoneyRectangle, numOfStations);
            case "最短时间":
                return userBasicService.minRes(startNum, destinationNum, TimeRectangle, numOfStations);
        }
        return null;
    }

    //进行各阶段资源消耗，以及总资源消耗，并放入request作用域
    private void CalculatorResource(Integer arrayLen, HttpServletRequest request, Integer[] len, Integer[] money, Integer[] time) {
        //1.总路程
        Integer totalLen = 0;
        //2.总金额
        Integer totalMoney = 0;
        //3.总时间
        Integer totalTime = 0;

        for (int i = 0; i < arrayLen; i++) {
            money[i] = MoneyRectangle[pathArray[i]][pathArray[i + 1]];
            totalMoney += money[i];

            len[i] = DistanceRectangle[pathArray[i]][pathArray[i + 1]];
            totalLen += len[i];

            time[i] = TimeRectangle[pathArray[i]][pathArray[i + 1]] / 60;
            totalTime += time[i];
        }

        request.setAttribute("totalLen", totalLen);
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("totalTime", totalTime);

    }

    //将路程信息放入request作用域
    private void setPathInfo(Integer arrayLen, HttpServletRequest request, Integer[] len, Integer[] money, Integer[] time) {
        //根据pathArray获取所有的始发站和终点站
        String[] beginStations = new String[arrayLen];
        String[] endStations = new String[arrayLen];

        for (int i = 0; i < arrayLen; i++) {
            beginStations[i] = stationsKeyId.get(pathArray[i]).getName();
            endStations[i] = stationsKeyId.get(pathArray[i + 1]).getName();
        }

        //获取所有的路程信息，并放入作用域中
        Record[] records = new Record[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            records[i] = new Record(i + 1, beginStations[i], endStations[i], len[i], time[i], money[i]);
        }
        List<Record> recordList = Arrays.asList(records);
        request.setAttribute("recordList", recordList);
    }

}
