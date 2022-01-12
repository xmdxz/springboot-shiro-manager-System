package com.house.service;

import com.house.pojo.Apply;
import com.house.pojo.ApplyOut;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName ApplyService
 * @Description TODO
 * @Date 2022/1/12 1:30
 */
public interface ApplyService {
    List<Apply> getAllApply(Integer pageNum, Integer num);

    Integer getApplyCount();

    Integer agreeApply(Integer id, String houseId);

    Integer refuseApply(Integer id, String houseId);

    List<ApplyOut> getAllApplyOut(Integer pageNum, Integer num);

    Integer getApplyOutCount();

    Integer agreeApplyOut(Integer id, String houseId);

    Integer refuseApplyOut(Integer id, String houseId);

    Integer deleteApplyOut(Integer id);

    List<Apply> getZuAllApply(Integer pageNum, Integer num);

    Integer getZuApplyCount();

    List<ApplyOut> getZuAllApplyOut(Integer pageNum, Integer num);

    Integer getZuApplyOutCount();
}
