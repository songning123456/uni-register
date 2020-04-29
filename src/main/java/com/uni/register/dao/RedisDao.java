package com.uni.register.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author songning
 * @date 2020/4/29
 * description
 */
@Component
public class RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void setValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void deleteValues(String dir) {
        Set<String> sets = stringRedisTemplate.keys(dir + "*");
        stringRedisTemplate.delete(sets);
    }
}
