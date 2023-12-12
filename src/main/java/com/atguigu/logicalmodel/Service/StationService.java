package com.atguigu.logicalmodel.Service;

public interface StationService {

    int getStationNum();

    int getStationIdByName(String stationName);

    String getStationNameById(int stationId);

    boolean stationsAllExist(String begin,String destination);
}
