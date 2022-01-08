package com.house.service;

import com.house.pojo.User;

/**
 * @Author xpdxz
 * @ClassName UserService
 * @Description TODO
 * @Date 2022/1/8 11:50
 */
public interface UserService {

    /**
     * 获取用户一般用于登录
     *
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

}
