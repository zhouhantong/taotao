package com.zht.taotao.service;

import com.zht.taotao.common.pojo.EaUIResult;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbItem;

/**
 * Created by Administrator on 2018/3/21.
 */
public interface TbItemServices {
     TbItem selectTbTtemById(Long id);
     EaUIResult pageTbItemList(int page,int pageSize);
     TaotaoResult insertTbItem(TbItem tbItem);
}
