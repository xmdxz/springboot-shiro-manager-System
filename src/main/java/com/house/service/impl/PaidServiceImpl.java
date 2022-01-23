package com.house.service.impl;

import com.github.pagehelper.page.PageMethod;
import com.house.dao.PaidDao;
import com.house.pojo.Paid;
import com.house.pojo.ToPaid;
import com.house.service.PaidService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName PaidServiceImpl
 * @Description TODO
 * @Date 2022/1/12 1:40
 */
@Service
public class PaidServiceImpl implements PaidService {

    @Resource
    private PaidDao paidDao;

    @Override
    public List<ToPaid> getAllToPaid(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return paidDao.getAllToPaid();
    }

    @Override
    public Integer getAllToPaidCount() {
        return paidDao.getAllToPaidCount();
    }

    @Override
    public List<Paid> getAllPaid(String name, Date fromDate, Date toDate, Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return paidDao.getAllPaid(name, fromDate, toDate);
    }

    @Override
    public Integer getAllPaidCount(String name, Date fromDate, Date toDate) {
        return paidDao.getAllPaidCount(name, fromDate, toDate);
    }

    @Override
    public Integer deletePaid(Integer id) {
        return paidDao.deletePaid(id);
    }
}
