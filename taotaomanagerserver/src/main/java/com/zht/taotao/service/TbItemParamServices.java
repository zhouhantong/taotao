package com.zht.taotao.service;

import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbItemParam;

/**
 * Created by zhouhantong on 2018/4/2.
 *
 * @author 周寒通
 */
public interface TbItemParamServices {
    TaotaoResult getTbItemParamByCid(long cid);

    EazyUiResult selectItemParamList(int page,int pageSize);

    TaotaoResult insertTbItemParam(TbItemParam tbItemParam)throws Exception;
}
