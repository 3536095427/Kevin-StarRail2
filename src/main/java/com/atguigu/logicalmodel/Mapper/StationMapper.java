package com.atguigu.logicalmodel.Mapper;

import com.atguigu.logicalmodel.pojo.Station;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StationMapper extends BaseMapper<Station> {
    Station getStationById(@Param("id") int id);

    String getStationNameById(@Param("id") int id);
}
