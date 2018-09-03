package com.zht.taotao.rest.service;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbContent;

/**
 * Created by zhouhantong on 2018/4/11.
 *
 * @author 周寒通
 */
public interface ContentServices {
    TaotaoResult getContentList(long categoryId);
}
