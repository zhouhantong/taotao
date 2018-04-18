package com.zht.taotao.protal.service;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.protal.pojo.ItemSeachResult;
import com.zht.taotao.protal.pojo.ItemSearch;

/**
 * Created by zhouhantong on 2018/4/18.
 *
 * @author 周寒通
 */
public interface ItemSeachServices {
    ItemSeachResult itemSearchQueryList(String queryString, int page);
}
