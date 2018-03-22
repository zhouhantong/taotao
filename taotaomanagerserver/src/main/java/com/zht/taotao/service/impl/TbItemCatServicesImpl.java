package com.zht.taotao.service.impl;

import com.zht.taotao.common.EUITreeNode;
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
    public List<EUITreeNode> getCatList(Long parentId) {
        List<TbItemCat>list=tbItemCatMapper.selectTbItemCatByParentId(parentId);
        List<EUITreeNode>euiTreeNodes=new ArrayList<>();
        for (TbItemCat tb:list) {
            EUITreeNode euiTreeNode=new EUITreeNode();
            euiTreeNode.setId(tb.getId());
            euiTreeNode.setText(tb.getName());
            euiTreeNode.setState(tb.getIsParent()?"closed":"open");
            euiTreeNodes.add(euiTreeNode);
        }
        return euiTreeNodes;
    }
}
