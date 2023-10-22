package com.atguigu.logicalmodel.Service.Imp;


import com.atguigu.logicalmodel.Service.TravelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("travelService")
@Transactional
public class TravelServiceImp implements TravelService {
}
