package com.zht.taotao.service;

import com.zht.taotao.common.pojo.EazyUiTreeNode;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbContentCategory;

import java.util.List;

/**
 * Created by zhouhantong on 2018/4/10.
 *
 * @author 周寒通
 */
public interface TbContentCategoryServices {
    List<EazyUiTreeNode>getContentCategoryList(long parentId);
    TaotaoResult insertContentCategoryList(TbContentCategory tbContentCategory);
    TaotaoResult deleteContentCategory(long id);
    TaotaoResult updateContentCategory(TbContentCategory tbContentCategory);
}
