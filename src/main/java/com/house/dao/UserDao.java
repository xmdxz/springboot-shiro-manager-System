package com.house.dao;

import com.house.pojo.User;
import com.house.pojo.UserInfo;
import com.house.pojo.dto.UserDto;

import java.util.List;

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

    /**
     * id
     *
     * @param id
     * @return
     */
    User selectUserById(Integer id);

    /**
     * 查询权限
     *
     * @param id
     * @return
     */
    String selectTypeById(Integer id);

    List<UserDto> getUsers(Integer pageNum, Integer num);

    Integer getUserCount();

    Integer deleteUser(Integer id);

    Integer deleteUserInfo(Integer id);

    Integer getUserInfoId(Integer id);

    Integer updateUserInfo(UserInfo userInfo);

}
