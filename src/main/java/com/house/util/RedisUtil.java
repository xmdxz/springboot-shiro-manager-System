package com.house.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author xpdxz
 * @ClassName RedisUtil
 * @Description TODO
 * @Date 2022/1/8 17:29
 */
@Component
public class RedisUtil {

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    //============================common================

    /**
     * 过期时间
     */
    public static void expire(String key, long time) {
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 包含某个key
     */
    public static boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * 删除
     *
     * @param keys
     */
    public static void delete(String... keys) {
        if (keys != null && keys.length > 0) {
            if (keys.length == 1) {
                redisTemplate.delete(keys[0]);
            } else {
                redisTemplate.delete(Arrays.asList(keys));
            }
        }
    }

    /**
     * 删除
     *
     * @param keys
     */
    public static void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    //===============================operation============================

    /**
     * 获取
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 插入并设置时间
     *
     * @param key
     * @param value
     * @param expire
     */
    public static void set(String key, Object value, long expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * 插入
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取指定前缀的key
     *
     * @param prefix
     * @return
     */
    public static Set<String> keysPrefix(String prefix) {
        return redisTemplate.execute(new RedisCallback<Set<String>>() {

            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
                Set<String> keys = new HashSet<>();
                Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match(prefix + "*").count(1000).build());
                while (cursor.hasNext()) {
                    keys.add(new String(cursor.next()));
                }
                return keys;
            }
        });
    }

    /**
     * 获取指定前缀key的数目
     *
     * @param prefix
     * @return
     */
    public static Long keysPrefixSize(String prefix) {
        return redisTemplate.execute(new RedisCallback<Long>() {

            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                Long num = 0L;
                Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match(prefix + "*").count(1000).build());
                while (cursor.hasNext()) {
                    cursor.next();
                    num++;
                }
                return num;
            }
        });
    }
}
