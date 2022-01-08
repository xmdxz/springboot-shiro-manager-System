package com.house.dao;

import com.house.pojo.User;

/**
 * @Author xpdxz
 * @ClassName UserDao
 * @Description TODO
 * @Date 2022/1/8 10:32
 */
public interface UserDao {

    /**
     * username
     *
     * @param userName
     * @return
     */
    User selectUserByUserName(String userName);

}
