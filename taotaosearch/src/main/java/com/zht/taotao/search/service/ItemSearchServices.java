package com.zht.taotao.search.service;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.search.pojo.ItemSeachResult;


/**
 * Created by zhouhantong on 2018/4/18.
 *
 * @author 周寒通
 */
public interface ItemSearchServices {
    TaotaoResult importItemList();
    ItemSeachResult itemSearchQueryList(String queryString, int page, int rows) throws Exception;
}
