package com.house.shiro;

import com.house.util.RedisUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.*;

/**
 * @Author xpdxz
 * @ClassName ShiroRedisCache
 * @Description TODO
 * @Date 2022/1/8 17:39
 */
public class ShiroRedisCache<K, V> implements Cache<K, V> {

    private String cacheName;

    public ShiroRedisCache(String cacheName) {
        this.cacheName = cacheName;
    }

    @Override
    public V get(K k) throws CacheException {
        return (V) RedisUtil.get(cacheName + k);
    }

    @Override
    public V put(K k, V v) throws CacheException {
        RedisUtil.set(cacheName + k.toString(), v);
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        final V o = (V) RedisUtil.get(cacheName + k.toString());
        RedisUtil.delete(k.toString());
        return o;
    }

    @Override
    public void clear() throws CacheException {
        Set<String> keysPrefix = RedisUtil.keysPrefix(cacheName + "*");
        RedisUtil.delete(keysPrefix);
    }

    @Override
    public int size() {
        return (int) (long) RedisUtil.keysPrefixSize(cacheName + "*");
    }

    @Override
    public Set<K> keys() {
        Set<String> set = RedisUtil.keysPrefix(cacheName);
        Set<K> result = new HashSet<>();
        set.forEach(e -> result.add((K) e));
        return result;
    }

    @Override
    public Collection<V> values() {
        List<V> result = new ArrayList<>();
        Set<String> set = RedisUtil.keysPrefix(cacheName);
        set.forEach(e -> result.add((V) RedisUtil.get(e)));
        return result;
    }


}
