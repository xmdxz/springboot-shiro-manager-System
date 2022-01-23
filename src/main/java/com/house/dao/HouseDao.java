package com.house.dao;

import com.house.pojo.House;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName HouseDao
 * @Description TODO
 * @Date 2022/1/11 12:06
 */
public interface HouseDao {

    /**
     * 获取所有房源信息
     *
     * @return
     */
    List<House> selectHouse();

    Integer selectHouseCount();

    Integer deleteHouse(Integer id);

    Integer addHouse(House house);

    Integer updateHouse(House house);

    House getHouseById(Integer id);
}
