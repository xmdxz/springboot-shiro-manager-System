package com.house.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
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

    public void setTimeout(long timeout) {
        JwtUtil.seconds = timeout;
    }

    public static String getJwtToken(Map<String, Object> body) {
        Calendar instance = Calendar.getInstance();
        body.put("createTime", instance.getTime());
        instance.add(Calendar.SECOND, (int) seconds);
        return JWT.create().withPayload(body).withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(salt));
    }

    public static String getJwtToken(String key, String value) {
        Calendar instance = Calendar.getInstance();
        Date createTime = instance.getTime();
        instance.add(Calendar.SECOND, (int) seconds);
        return JWT.create().withClaim(key, value).withClaim("createTime", createTime).withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(salt));
    }

    public static Object getBodyMessage(String key, String token) {
        return JWT.decode(token).getClaim(key);
    }

    public static boolean signToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(salt)).build().verify(token);
            return true;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
    }
}
