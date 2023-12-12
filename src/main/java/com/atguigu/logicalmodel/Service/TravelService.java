package com.atguigu.logicalmodel.Service;

public interface TravelService {


    int[] getPathArray(String type, String beginStation, String destinationStation);

    int[] getPathByArray(int[] front, Integer start, Integer destination);

    int getTotalLenByPath(int[] pathArray);

    int getTotalMoneyByPath(int[] pathArray);

    int getTotalTimeByPath(int[] pathArray);

    String getPathStationInfo(int[] pathArray);
}
