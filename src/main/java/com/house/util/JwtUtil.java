package com.house.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

/**
 * @Author xpdxz
 * @ClassName JWTUtil
 * @Description TODO
 * @Date 2022/1/8 8:19
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil {
    private static String salt;
    private static long seconds;

    public void setSalt(String salt) {
        JwtUtil.salt = salt;
    }

    public void setSeconds(long seconds) {
        JwtUtil.seconds = seconds;
    }

    public String getJwtToken(Map<String, Object> body) {
        Calendar instance = Calendar.getInstance();
        body.put("createTime", instance.getTime());
        instance.add(Calendar.SECOND, (int) seconds);
        return JWT.create().withPayload(body).withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(salt));
    }

    public Object getBodyMessage(String key, String token) {
        return JWT.decode(token).getClaim(key);
    }

    public boolean signToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(salt)).build().verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
