package com.zht.taotao.service;

import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbItem;

/**
 * Created by Administrator on 2018/3/21.
 */
public interface TbItemServices {
     TbItem selectTbTtemById(Long id);
     EazyUiResult pageTbItemList(int page, int pageSize);
     TaotaoResult insertTbItem(TbItem tbItem,String desc,String itemParams)throws Exception;
}
