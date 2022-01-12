package com.house.controller;

import com.house.pojo.UserInfo;
import com.house.service.UserService;
import com.house.util.ResponseResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xpdxz
 * @ClassName UserController
 * @Description TODO
 * @Date 2022/1/12 1:27
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/getUsers")
    public ResponseResult getUsers(Integer pageNum, Integer num) {
        return ResponseResult.ok(userService.getUsers(pageNum, num));
    }

    @GetMapping(value = "/getUserCount")
    public ResponseResult getUserCount() {
        return ResponseResult.ok(userService.getUserCount());
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseResult deleteUser(Integer id) {
        return ResponseResult.ok(userService.deleteUser(id));
    }

    @GetMapping(value = "/updateUserInfo")
    public ResponseResult updateUserInfo(UserInfo userInfo) {
        return ResponseResult.ok(userService.updateUserInfo(userInfo));
    }

}
