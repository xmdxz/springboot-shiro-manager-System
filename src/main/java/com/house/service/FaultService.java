package com.house.service;

import com.house.pojo.Solve;
import com.house.pojo.Wrong;

import java.sql.Date;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName FaultService
 * @Description TODO
 * @Date 2022/1/12 1:31
 */
public interface FaultService {

    List<Wrong> getAllFault(Integer pageNum, Integer num);

    Integer getFaultCount();

    Integer agreeSolve(Integer id);

    List<Solve> getSolves(String name, Date fromDate, Date toDate, Integer pageNum, Integer num);

    Integer getSolvesCount(String name, Date fromDate, Date toDate);

    List<Solve> getZuSolves(String name, Date fromDate, Date toDate, Integer pageNum, Integer num);

    Integer getZuSolvesCount(String name, Date fromDate, Date toDate);

    Integer deleteSolve(Integer id);

    Integer addWrong(Wrong wrong);
}
