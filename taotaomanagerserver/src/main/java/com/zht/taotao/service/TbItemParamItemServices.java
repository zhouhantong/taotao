package com.zht.taotao.service;

import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.pojo.TbItemParamItemMap;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhantong on 2018/4/8.
 *  商品规格参数展示
 * @author 周寒通
 */
public interface TbItemParamItemServices {
    String showTbItemParamItemByItemId(Long id);

    EazyUiResult findTbItemParamItemList(int page,int pageSize,TbItemParamItemMap tbItemParamItemMap);
}
