package com.house.controller;

import com.house.pojo.User;
import com.house.service.UserService;
import com.house.util.JwtUtil;
import com.house.util.RequestUtil;
import com.house.util.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xpdxz
 * @ClassName LoginController
 * @Description TODO
 * @Date 2022/1/9 12:21
 */


@RestController
@Log4j2
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseResult> login(String username, String password, String type, HttpServletRequest request) {
        if (RequestUtil.allParamsIsNull(username, password, type)) {
            return ResponseEntity.ok(ResponseResult.error(501, "非法请求"));
        }
        User user = userService.getUserByUserName(username);
        if (!password.equals(user.getPassword()) || !type.equals(user.getType())) {
            return ResponseEntity.ok(ResponseResult.other(405, "密码错误,请重试"));
        }
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", user.getId());
        map.put("username", username);
        map.put("userInfoId", userService.getUserInfoId(user.getId()));
        String cookie = "jwt=" + JwtUtil.getJwtToken(map) + ";path=/;HttpOnly";
        log.debug(cookie);
        return ResponseEntity.ok().header("Set-Cookie", cookie).header("Set-Cookie", "username=" + username + ";path=/").body(ResponseResult.ok("登陆成功", user.getType()));
    }

}
