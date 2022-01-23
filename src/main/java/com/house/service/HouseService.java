package com.house.service;

import com.house.pojo.House;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName HouseService
 * @Description TODO
 * @Date 2022/1/11 12:24
 */
public interface HouseService {

    /**
     * 获取房源信息
     *
     * @return
     */
    List<House> getHouses(Integer pageNum, Integer num);


    /**
     * 获取房源总书
     *
     * @return
     */
    Integer getHouseCount();

    Integer updateHouse(House house);

    Integer addHouse(House house);

    Integer deleteHouse(Integer id);

    House getHouse(Integer id);

    Integer applyHouse(House house);
}
