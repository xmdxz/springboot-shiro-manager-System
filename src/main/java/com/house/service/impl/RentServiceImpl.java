package com.house.service.impl;

import com.github.pagehelper.page.PageMethod;
import com.house.dao.ApplyDao;
import com.house.dao.RentDao;
import com.house.pojo.ApplyOut;
import com.house.pojo.Contract;
import com.house.pojo.dto.RentInfo;
import com.house.service.RentService;
import com.house.util.RequestUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName RentServiceImpl
 * @Description TODO
 * @Date 2022/1/11 17:11
 */
@Service
public class RentServiceImpl implements RentService {

    @Resource
    private RentDao rentDao;

    @Resource
    private ApplyDao applyDao;

    @Override
    public List<RentInfo> getAllRentInfo(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return rentDao.selectAllRentInfo();
    }

    @Override
    public Integer getRentCount() {
        return rentDao.selectRentCount();
    }

    @Override
    public Integer deleteContract(Integer contractId) {
        return rentDao.deleteContract(contractId);
    }

    @Override
    public Contract getContractById(Integer contractId) {
        return rentDao.selectContractById(contractId);
    }

    @Override
    public List<RentInfo> getAllCheckout(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return rentDao.selectAllCheckout();
    }

    @Override
    public Integer getCheckoutCount() {
        return rentDao.selectCheckoutCount();
    }

    @Override
    public Integer deleteCheckout(Integer id) {
        return rentDao.deleteCheckout(id);
    }

    @Override
    public Integer updateContract(Contract contract) {
        return rentDao.updateContract(contract);
    }

    @Override
    public Integer getZuRentCount() {
        return rentDao.getZuRentCount(RequestUtil.getUserInfoId());
    }

    @Override
    public Integer applyOut(RentInfo rentInfo) {
        ApplyOut applyOut = new ApplyOut();
        applyOut.setStatus("申请中");
        applyOut.setAddress(rentInfo.getAddress());
        applyOut.setHouseId(rentInfo.getHouseId());
        applyOut.setUserListId(RequestUtil.getUserInfoId());
        return applyDao.insertApplyOut(applyOut);
    }

    @Override
    public Integer getZuCheckoutCount() {
        return rentDao.selectZuCheckoutCount(RequestUtil.getUserInfoId());
    }

    @Override
    public RentInfo getRentInfoById(Integer id) {
        return rentDao.getZuById(id);
    }

    @Override
    public List<RentInfo> getZuAllCheckout(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return rentDao.selectZuAllCheckout(RequestUtil.getUserInfoId());
    }

    @Override
    public List<RentInfo> getZuRents(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return rentDao.getZuRents(RequestUtil.getUserInfoId());
    }
}
