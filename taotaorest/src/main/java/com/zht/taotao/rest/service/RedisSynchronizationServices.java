package com.zht.taotao.rest.service;

import com.zht.taotao.common.util.TaotaoResult;

/**
 * Created by zhouhantong on 2018/4/17.
 *
 * @author 周寒通
 */
public interface RedisSynchronizationServices {
    TaotaoResult syncContent(long contenId);
}
