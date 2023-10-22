package com.atguigu.logicalmodel.Service.Imp;


import com.atguigu.logicalmodel.Mapper.UserBasicMapper;
import com.atguigu.logicalmodel.Mapper.UserDetailMapper;
import com.atguigu.logicalmodel.Service.UserBasicService;
import com.atguigu.logicalmodel.pojo.UserBasic;
import com.atguigu.logicalmodel.pojo.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Service("userBasicService")
@Transactional
public class UserBasicServiceImp implements UserBasicService {

    @Autowired
    private UserBasicMapper userBasicMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;


    @Override
    public UserBasic Login(Integer loginID, String password) {
        if (loginID == null) {
            return null;
        }

        //如果根据id无法查询到userBasic
        UserBasic userBasic = userBasicMapper.selectById(loginID);

        //数据库中不存在这个用户，返回null
        if (userBasic == null) {
            return null;
        }

        //获取真实用户的密码
        String passwordGet = userBasic.getPassword();

        //如果密码错误，返回null
        if (!password.equals(passwordGet)) {
            return null;
        }

        return userBasic;
    }

    @Override
    public UserDetail getUserDetailById(Integer id) {
        return userDetailMapper.selectById(id);
    }

    @Override
    public int[] minRes(Integer start, Integer destination, final Integer[][] rectangle, Integer numOfStation) {
        //调用迪杰斯特拉算法，将计算结果存储到frontStation数组中
        int[] frontStation;
        frontStation = Dijkstra(start, destination, rectangle, numOfStation);

        return getPathByArray(frontStation, start, destination);
    }

    @Override
    public int[] Dijkstra(Integer start, Integer destination, final Integer[][] rectangle, int numOfStation) {
        boolean[] isVisited = new boolean[numOfStation + 1];
        int[] value = new int[numOfStation + 1];
        int[] frontStation = new int[numOfStation + 1];

        int Temp_point = start;
        Arrays.fill(value, Integer.MAX_VALUE);
        Arrays.fill(frontStation, Temp_point);
        value[Temp_point] = 0;
        isVisited[Temp_point] = true;


        for (int i = 1; i <= numOfStation - 1; i++) {
            //根据临时点刷新从这个点到各个顶点的路程长度和花费
            for (int j = 1; j <= numOfStation; j++) {
                if (rectangle[Temp_point][j] != null) {
                    if (rectangle[Temp_point][j] != 0) {
                        //如果新路径的长度小于原路径，直接全部刷新
                        if (rectangle[Temp_point][j] + value[Temp_point] < value[j]) {
                            value[j] = rectangle[Temp_point][j] + value[Temp_point];
                            frontStation[j] = Temp_point;
                        }
                    }
                }
            }
            int Min = Integer.MAX_VALUE;
            int temp = 0;
            for (int j = 1; j <= numOfStation; j++) {
                if (isVisited[j] == false && value[j] < Min) {
                    Min = value[j];
                    temp = j;
                }
            }
            Temp_point = temp;
            isVisited[Temp_point] = true;
        }

        return frontStation;

    }

    @Override
    public int[] getPathByArray(int[] frontStation, Integer start, Integer destination) {
        //因为经过的站点数量并不确定，所以使用ArrayList
        ArrayList<Integer> arrayList = new ArrayList();

        //倒数第一个车站，就是终点站的前一个
        int front = frontStation[destination];
        arrayList.add(destination);
        arrayList.add(front);

        while (true) {
            front = frontStation[front];
            //不断循环，直到根据某个城市的前置编号就是起点
            if (front == start) break;
            arrayList.add(front);
        }

        //将起点放入路线数组
        if (!arrayList.contains(start)) {
            arrayList.add(start);
        }

        //将得到arrayList反转一下，即可得到最终结果
        Collections.reverse(arrayList);

        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
};