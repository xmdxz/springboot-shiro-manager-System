package com.house.service;

import com.house.pojo.Paid;
import com.house.pojo.ToPaid;

import java.sql.Date;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName PaidService
 * @Description TODO
 * @Date 2022/1/12 1:31
 */
public interface PaidService {

    List<ToPaid> getAllToPaid(Integer pageNum, Integer num);

    Integer getAllToPaidCount();

    List<Paid> getAllPaid(String name, Date fromDate, Date toDate, Integer pageNum, Integer num);

    Integer getAllPaidCount(String name, Date fromDate, Date toDate);

    Integer deletePaid(Integer id);
}
