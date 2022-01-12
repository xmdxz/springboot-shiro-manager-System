package com.house.service.impl;

import com.github.pagehelper.page.PageMethod;
import com.house.dao.UserDao;
import com.house.pojo.User;
import com.house.pojo.UserInfo;
import com.house.pojo.dto.UserDto;
import com.house.service.UserService;
import com.house.util.RequestUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2022/1/8 11:51
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUserByUserName(String userName) {
        return userDao.selectUserByUserName(userName);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.selectUserById(id);
    }

    @Override
    public String getTypeById(Integer id) {
        return userDao.selectTypeById(id);
    }

    @Override
    public List<UserDto> getUsers(Integer pageNum, Integer num) {
        PageMethod.startPage(pageNum, num);
        return userDao.getUsers(pageNum, num);
    }

    @Override
    public Integer getUserCount() {
        return userDao.getUserCount();
    }

    @Transactional(rollbackFor = SQLException.class)
    @Override
    public Integer deleteUser(Integer id) {
        return userDao.deleteUser(id) + userDao.deleteUserInfo(id);
    }

    @Override
    public Integer getUserInfoId(Integer id) {
        return userDao.getUserInfoId(id);
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        userInfo.setId(RequestUtil.getUserInfoId());
        return userDao.updateUserInfo(userInfo);
    }
}
