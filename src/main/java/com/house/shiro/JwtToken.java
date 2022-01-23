package com.house.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author xpdxz
 * @ClassName JwtToken
 * @Description TODO
 * @Date 2022/1/8 10:17
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
