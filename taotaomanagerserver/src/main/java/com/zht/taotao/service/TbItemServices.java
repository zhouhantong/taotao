package com.zht.taotao.service;

import com.zht.taotao.common.pojo.EaUIResult;
import com.zht.taotao.pojo.TbItem;

/**
 * Created by Administrator on 2018/3/21.
 */
public interface TbItemServices {
    public TbItem selectTbTtemById(Long id);
    public EaUIResult pageTbItemList(int page,int pageSize);
}
