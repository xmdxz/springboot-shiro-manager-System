package com.house.service;

import com.house.pojo.User;
import com.house.pojo.UserInfo;
import com.house.pojo.dto.UserDto;

import java.util.List;

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

    /**
     * 获取用户
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 获取权限
     *
     * @param id
     * @return
     */
    String getTypeById(Integer id);


    List<UserDto> getUsers(Integer pageNum, Integer num);

    Integer getUserCount();

    Integer deleteUser(Integer id);

    Integer getUserInfoId(Integer id);

    Integer updateUserInfo(UserInfo userInfo);
}
