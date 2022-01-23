package com.house.dao;

import com.house.pojo.Solve;
import com.house.pojo.Wrong;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName FaultDao
 * @Description TODO
 * @Date 2022/1/12 1:44
 */
public interface FaultDao {

    List<Wrong> getAllFault();

    Integer getFaultCount();

    Integer insertSolve(Wrong wrong);

    List<Solve> getSolves(@Param("name") String name, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    Integer getSolvesCount(@Param("name") String name, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    Integer deleteSolve(Integer id);

    Wrong selectWrongById(Integer id);

    Integer updateWrong(Wrong wrong);

    Integer insertWrong(Wrong wrong);

    List<Solve> getZuSolves(@Param("name") String name, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("userInfoId") Integer userInfoId);

    Integer getZuSolvesCount(@Param("name") String name, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("userInfoId") Integer userInfoId);
}
