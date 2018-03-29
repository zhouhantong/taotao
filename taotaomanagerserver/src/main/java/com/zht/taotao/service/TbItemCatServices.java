package com.zht.taotao.service;

import com.zht.taotao.common.pojo.EazyUiTreeNode;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface TbItemCatServices {
    List<EazyUiTreeNode> getCatList(Long parentId);
}
