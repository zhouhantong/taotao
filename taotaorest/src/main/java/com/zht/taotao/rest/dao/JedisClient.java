package com.zht.taotao.rest.dao;

/**
 * Created by zhouhantong on 2018/4/16.
 *  Jedis DAO
 * @author 周寒通
 */
public interface JedisClient {
    String get(String key);
    String set(String key,String value);
    String hget(String key,String field);
    long hset(String key,String field,String value);
    long incr(String key);
    long expire(String key ,int secend);
    long ttl(String key);
    long del(String key);
    long hdel(String key,String field);
}
