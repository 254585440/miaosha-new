package com.travel.function.config;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {

    private final String id;

    private RedisTemplate redisTemplate;

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        getRedisTemplate();
        redisTemplate.opsForHash().put(id,o.toString(),o1);
    }

    @Override
    public Object getObject(Object o) {
        getRedisTemplate();
        return redisTemplate.opsForHash().get(id,o.toString());
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {
        getRedisTemplate();
        redisTemplate.opsForHash().delete(id);
    }

    @Override
    public int getSize() {
        getRedisTemplate();
        return redisTemplate.opsForHash().size(id).intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    private void getRedisTemplate(){
        redisTemplate = (RedisTemplate) ApplicationContextConfig.getBeanByName("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    }
}
