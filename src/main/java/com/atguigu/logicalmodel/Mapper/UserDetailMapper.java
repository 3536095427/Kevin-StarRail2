package com.atguigu.logicalmodel.Mapper;

import com.atguigu.logicalmodel.pojo.UserDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailMapper extends BaseMapper<UserDetail> {
}
