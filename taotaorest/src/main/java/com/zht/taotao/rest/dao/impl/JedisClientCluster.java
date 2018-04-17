package com.zht.taotao.rest.dao.impl;

import com.zht.taotao.rest.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

/**
 * Created by zhouhantong on 2018/4/16.
 *
 * @author 周寒通
 */
public class JedisClientCluster implements JedisClient{
    @Autowired
    private JedisCluster jedisCluster;
    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String hget(String key, String field) {
        return jedisCluster.hget(key, field);
    }

    @Override
    public long hset(String key, String field, String value) {
        return jedisCluster.hset(key, field, value);
    }

    @Override
    public long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public long expire(String key, int secend) {
        return jedisCluster.expire(key, secend);
    }

    @Override
    public long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    @Override
    public long del(String key) {
        return jedisCluster.del(key);
    }

    @Override
    public long hdel(String key, String field) {
        return jedisCluster.hdel(key,field);
    }
}
