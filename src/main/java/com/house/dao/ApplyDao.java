package com.house.dao;

import com.house.pojo.Apply;
import com.house.pojo.ApplyOut;

import java.util.List;

/**
 * @Author xpdxz
 * @ClassName ApplyDao
 * @Description TODO
 * @Date 2022/1/12 1:44
 */
public interface ApplyDao {
    List<Apply> getAllApply();

    Integer getApplyCount();

    Integer updateApply(Apply apply);

    Integer insertApply(Apply apply);


    List<ApplyOut> getAllApplyOut();

    Integer getApplyOutCount();

    Integer updateApplyOut(ApplyOut apply);


    Integer deleteApplyOut(Integer id);

    Integer insertApplyOut(ApplyOut applyOut);

    List<Apply> getZuAllApply(Integer id);

    Integer getZuApplyCount(Integer id);

    List<ApplyOut> getZuAllApplyOut(Integer id);

    Integer getZuApplyOutCount(Integer id);
}
