package com.house.service.impl;

import com.github.pagehelper.page.PageMethod;
import com.house.dao.ApplyDao;
import com.house.dao.HouseDao;
import com.house.pojo.Apply;
import com.house.pojo.ApplyOut;
import com.house.pojo.House;
import com.house.service.ApplyService;
import com.house.util.RequestUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName ApplyServiceImpl
 * @Description TODO
 * @Date 2022/1/12 1:38
 */
@Service
@Transactional(rollbackFor = SQLException.class)
public class ApplyServiceImpl implements ApplyService {

    @Resource
    private ApplyDao applyDao;

    @Resource
    private HouseDao houseDao;

    @Override
    public List<Apply> getAllApply(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return applyDao.getAllApply();
    }

    @Override
    public Integer getApplyCount() {
        return applyDao.getApplyCount();
    }

    @Override
    public Integer agreeApply(Integer id, String houseId) {
        Apply apply = new Apply();
        apply.setId(id);
        apply.setStatus("已同意");
        House house = new House();
        house.setHouseId(houseId);
        house.setStatus("已租赁");
        return applyDao.updateApply(apply) + houseDao.updateHouse(house);
    }

    @Override
    public Integer refuseApply(Integer id, String houseId) {
        Apply apply = new Apply();
        apply.setId(id);
        apply.setStatus("已拒绝");
        House house = new House();
        house.setHouseId(houseId);
        house.setStatus("未租赁");
        return applyDao.updateApply(apply) + houseDao.updateHouse(house);
    }

    @Override
    public List<ApplyOut> getAllApplyOut(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return applyDao.getAllApplyOut();
    }

    @Override
    public Integer getApplyOutCount() {
        return applyDao.getApplyOutCount();
    }

    @Override
    public Integer agreeApplyOut(Integer id, String houseId) {
        ApplyOut applyOut = new ApplyOut();
        applyOut.setId(id);
        applyOut.setStatus("已同意");
        House house = new House();
        house.setHouseId(houseId);
        house.setStatus("未租赁");
        return applyDao.updateApplyOut(applyOut) + houseDao.updateHouse(house);
    }

    @Override
    public List<Apply> getZuAllApply(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return applyDao.getZuAllApply(RequestUtil.getUserInfoId());
    }

    @Override
    public Integer getZuApplyCount() {
        return applyDao.getZuApplyCount(RequestUtil.getUserInfoId());
    }

    @Override
    public List<ApplyOut> getZuAllApplyOut(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return applyDao.getZuAllApplyOut(RequestUtil.getUserInfoId());
    }

    @Override
    public Integer getZuApplyOutCount() {
        return applyDao.getZuApplyOutCount(RequestUtil.getUserInfoId());
    }

    @Override
    public Integer refuseApplyOut(Integer id, String houseId) {
        ApplyOut applyOut = new ApplyOut();
        applyOut.setId(id);
        applyOut.setStatus("已拒绝");
        House house = new House();
        house.setHouseId(houseId);
        house.setStatus("已租赁");
        return applyDao.updateApplyOut(applyOut) + houseDao.updateHouse(house);
    }

    @Override
    public Integer deleteApplyOut(Integer id) {
        return applyDao.deleteApplyOut(id);
    }
}
