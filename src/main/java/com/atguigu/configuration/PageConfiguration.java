package com.atguigu.configuration;

import com.atguigu.interceptor.PageInterceptor;
import com.atguigu.logicalmodel.pojo.Station;
import com.atguigu.component.InfoInit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;

@Configuration
public class PageConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PageInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/css/**", "/img/**", "/favicon.ico");
    }

    //将所有车站的信息放入容器中，以name为键
    @Bean("allStationsKeyName")
    public HashMap<String, Station> getAllStationsKeyName(InfoInit infoInit) {
        return infoInit.InitStationsKeyName();
    }


    //将所有车站的信息放入容器中，以id为键
    @Bean("allStationsKeyId")
    public HashMap<Integer, Station> getAllStationsKeyId(InfoInit infoInit) {
        return infoInit.InitStationsKeyId();
    }

    @Bean("DistanceRectangle")
    public Integer[][] getDistanceRectangle(InfoInit infoInit) {
        return infoInit.InitRectangle().get("DistanceRectangle");
    }

    @Bean("MoneyRectangle")
    public Integer[][] getMoneyRectangle(InfoInit infoInit) {
        return infoInit.InitRectangle().get("MoneyRectangle");
    }

    @Bean("TimeRectangle")
    public Integer[][] getTimeRectangle(InfoInit infoInit) {
        return infoInit.InitRectangle().get("TimeRectangle");
    }
}
