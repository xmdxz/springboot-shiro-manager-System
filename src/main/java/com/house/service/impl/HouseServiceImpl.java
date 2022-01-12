package com.house.service.impl;

import com.github.pagehelper.page.PageMethod;
import com.house.dao.ApplyDao;
import com.house.dao.HouseDao;
import com.house.pojo.Apply;
import com.house.pojo.House;
import com.house.service.HouseService;
import com.house.util.RequestUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName HouseServiceImpl
 * @Description TODO
 * @Date 2022/1/11 12:25
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseDao houseDao;

    @Resource
    private ApplyDao applyDao;

    @Override
    public List<House> getHouses(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return houseDao.selectHouse();
    }

    @Override
    public Integer getHouseCount() {
        return houseDao.selectHouseCount();
    }

    @Override
    public Integer updateHouse(House house) {
        return houseDao.updateHouse(house);
    }

    @Override
    public Integer addHouse(House house) {
        return houseDao.addHouse(house);
    }

    @Override
    public Integer deleteHouse(Integer id) {
        return houseDao.deleteHouse(id);
    }

    @Override
    public House getHouse(Integer id) {
        return houseDao.getHouseById(id);
    }

    @Transactional(rollbackFor = SQLException.class)
    @Override
    public Integer applyHouse(House house) {
        Apply apply = new Apply();
        apply.setStatus("申请中");
        apply.setHouseId(house.getHouseId());
        apply.setArea(house.getArea());
        apply.setAddress(house.getAddress());
        apply.setPrice(house.getPrice());
        apply.setUserListId(RequestUtil.getUserInfoId());
        Integer integer = applyDao.insertApply(apply);
        house = new House();
        house.setStatus("已被申请");
        Integer house1 = houseDao.updateHouse(house);
        return integer + house1;
    }
}
