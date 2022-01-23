package com.house.service.impl;

import com.github.pagehelper.page.PageMethod;
import com.house.dao.FaultDao;
import com.house.pojo.Solve;
import com.house.pojo.Wrong;
import com.house.service.FaultService;
import com.house.util.RequestUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


/**
 * @Author xpdxz
 * @ClassName FaultServiceImpl
 * @Description TODO
 * @Date 2022/1/12 1:39
 */
@Service
@Transactional(rollbackFor = SQLException.class)
public class FaultServiceImpl implements FaultService {

    @Resource
    private FaultDao faultDao;

    @Override
    public List<Wrong> getAllFault(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return faultDao.getAllFault();
    }

    @Override
    public Integer getFaultCount() {
        return faultDao.getFaultCount();
    }

    @Override
    public Integer agreeSolve(Integer id) {
        Wrong wrong = new Wrong();
        wrong.setId(id);
        wrong.setStatus("已处理");
        Integer update = faultDao.updateWrong(wrong);
        wrong = faultDao.selectWrongById(id);
        Integer insert = faultDao.insertSolve(wrong);
        return update + insert;
    }

    @Override
    public List<Solve> getSolves(String name, Date fromDate, Date toDate, Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return faultDao.getSolves(name, fromDate, toDate);
    }

    @Override
    public Integer getSolvesCount(String name, Date fromDate, Date toDate) {
        return faultDao.getSolvesCount(name, fromDate, toDate);
    }

    @Override
    public List<Solve> getZuSolves(String name, Date fromDate, Date toDate, Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return faultDao.getZuSolves(name, fromDate, toDate, RequestUtil.getUserInfoId());
    }

    @Override
    public Integer getZuSolvesCount(String name, Date fromDate, Date toDate) {
        return faultDao.getZuSolvesCount(name, fromDate, toDate, RequestUtil.getUserInfoId());
    }

    @Override
    public Integer deleteSolve(Integer id) {
        return faultDao.deleteSolve(id);
    }

    @Override
    public Integer addWrong(Wrong wrong) {
        wrong.setStatus("申请中");
        wrong.setUserListId(RequestUtil.getUserInfoId());
        return faultDao.insertWrong(wrong);
    }
}
