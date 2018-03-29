package com.zht.taotao.service.impl;

import com.zht.taotao.common.pojo.EazyUiTreeNode;
import com.zht.taotao.mapper.TbItemCatMapper;
import com.zht.taotao.pojo.TbItemCat;
import com.zht.taotao.service.TbItemCatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class TbItemCatServicesImpl implements TbItemCatServices{
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    /**
     * 查询商品类别列表
     * @param parentId
     * @return
     */
    @Override
    public List<EazyUiTreeNode> getCatList(Long parentId) {
        List<TbItemCat>list=tbItemCatMapper.selectTbItemCatByParentId(parentId);
        List<EazyUiTreeNode> eazyUiTreeNodes =new ArrayList<>();
        for (TbItemCat tb:list) {
            EazyUiTreeNode eazyUiTreeNode =new EazyUiTreeNode();
            eazyUiTreeNode.setId(tb.getId());
            eazyUiTreeNode.setText(tb.getName());
            eazyUiTreeNode.setState(tb.getIsParent()?"closed":"open");
            eazyUiTreeNodes.add(eazyUiTreeNode);
        }
        return eazyUiTreeNodes;
    }
}
