package com.zht.taotao.rest.service.impl;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.rest.dao.JedisClient;
import com.zht.taotao.rest.service.RedisSynchronizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhouhantong on 2018/4/17.
 *  redis同步
 * @author 周寒通
 */
@Service
public class RedisSyncServicesImpl implements RedisSynchronizationServices {
    @Autowired
    private JedisClient jedisClient;
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;
    @Override
    public TaotaoResult syncContent(long contenId) {
        try {
            jedisClient.hdel(INDEX_CONTENT_REDIS_KEY,contenId+"");
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500,"同步异常");
        }
        return TaotaoResult.ok();
    }
}
