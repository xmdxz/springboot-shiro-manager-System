package com.house.service;

import com.house.pojo.Contract;
import com.house.pojo.dto.RentInfo;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName RentService
 * @Description TODO
 * @Date 2022/1/11 17:10
 */
public interface RentService {
    List<RentInfo> getAllRentInfo(Integer pageNum, Integer num);

    Integer getRentCount();

    Integer deleteContract(Integer contractId);

    Contract getContractById(Integer contractId);

    List<RentInfo> getAllCheckout(Integer pageNum, Integer num);

    Integer getCheckoutCount();

    Integer deleteCheckout(Integer id);

    Integer updateContract(Contract contract);

    List<RentInfo> getZuRents(Integer pageNum, Integer num);

    Integer getZuRentCount();

    Integer applyOut(RentInfo rentInfo);

    List<RentInfo> getZuAllCheckout(Integer pageNum, Integer num);

    Integer getZuCheckoutCount();

    RentInfo getRentInfoById(Integer id);
}
