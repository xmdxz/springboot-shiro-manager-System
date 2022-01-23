package com.house.dao;

import com.house.pojo.Paid;
import com.house.pojo.ToPaid;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName PaidDao
 * @Description TODO
 * @Date 2022/1/12 1:44
 */
public interface PaidDao {

    List<ToPaid> getAllToPaid();

    Integer getAllToPaidCount();

    List<Paid> getAllPaid(@Param("name") String name, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    Integer getAllPaidCount(@Param("name") String name, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    Integer deletePaid(Integer id);
}
