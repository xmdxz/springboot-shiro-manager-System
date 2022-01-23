package com.house.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @Author xpdxz
 * @ClassName ShiroCacheManager
 * @Description TODO
 * @Date 2022/1/9 10:47
 */
public class ShiroCacheManager implements CacheManager {
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new ShiroRedisCache<>(s);
    }
}
