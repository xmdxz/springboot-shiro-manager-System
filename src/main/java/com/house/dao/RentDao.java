package com.house.dao;

import com.house.pojo.Contract;
import com.house.pojo.dto.RentInfo;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName RentDao
 * @Description TODO
 * @Date 2022/1/11 17:11
 */
public interface RentDao {

    List<RentInfo> selectAllRentInfo();

    Integer selectRentCount();

    Integer deleteContract(Integer contractId);

    Contract selectContractById(Integer contractId);

    List<RentInfo> selectAllCheckout();

    Integer selectCheckoutCount();

    List<RentInfo> selectZuAllCheckout(Integer id);

    Integer selectZuCheckoutCount(Integer id);

    Integer deleteCheckout(Integer id);

    Integer updateContract(Contract contract);

    List<RentInfo> getZuRents(Integer userId);

    Integer getZuRentCount(Integer userId);

    RentInfo getZuById(Integer id);

}
