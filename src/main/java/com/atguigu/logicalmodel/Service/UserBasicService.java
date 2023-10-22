package com.atguigu.logicalmodel.Service;


import com.atguigu.logicalmodel.pojo.UserBasic;
import com.atguigu.logicalmodel.pojo.UserDetail;

public interface UserBasicService {
    UserBasic Login(Integer loginID, String password);

    UserDetail getUserDetailById(Integer id);

    int[] minRes(Integer start, Integer destination, final Integer[][] rectangle, Integer numOfStation);

    //Dijkstra计算结果的解释：
    /*
     * 索引从1位置开始，每个索引存储的数字的意义:要到达编号=索引的城市，需要先到达
     * 城市的编号，相当于标注访问这个结点之前，必须先要访问的结点/城市编号
     * */

    int[] Dijkstra(Integer start, Integer destination, final Integer[][] rectangle, int numOfStation);

    int[] getPathByArray(int[] front, Integer start, Integer destination);
}
