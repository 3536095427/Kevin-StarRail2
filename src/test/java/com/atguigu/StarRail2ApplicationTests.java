package com.atguigu;

import org.junit.jupiter.api.Disabled;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StarRail2ApplicationTests {


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
