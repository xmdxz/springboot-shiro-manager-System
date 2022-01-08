package com.house.service.impl;

import com.house.dao.UserDao;
import com.house.pojo.User;
import com.house.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
