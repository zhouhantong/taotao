package com.zht.taotao.service;

import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by zhouhantong on 2018/4/10.
 *
 * @author 周寒通
 */
public interface TbContentServices {
    EazyUiResult findContentListSeach(int page,int pageSize,TbContent tbContent);
    TaotaoResult insertContent(TbContent tbContent);
    TaotaoResult updateContent(TbContent tbContent);
    TaotaoResult deleteContentBatch(long[]ids);
}
