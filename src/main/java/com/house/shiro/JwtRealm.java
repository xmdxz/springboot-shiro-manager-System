package com.house.shiro;

import com.house.pojo.User;
import com.house.service.UserService;
import com.house.util.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @Author xpdxz
 * @ClassName JwtReam
 * @Description TODO
 * @Date 2022/1/8 11:34
 */

@Log4j2
public class JwtRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Integer id = Integer.parseInt((String) JwtUtil.getBodyMessage("id", principals.toString()));
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String type = userService.getTypeById(id);
        info.addRole(type);
        return info;
    }

    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.debug("执行登录");
        String jwt = (String) token.getPrincipal();
        User user = userService.getUserById(Integer.parseInt((JwtUtil.getBodyMessage("id", jwt).toString())));
        if (user == null) {
            throw new AuthenticationException("账户不存在");
        }
        return new SimpleAuthenticationInfo(jwt, jwt, "myRealm");
    }
}
