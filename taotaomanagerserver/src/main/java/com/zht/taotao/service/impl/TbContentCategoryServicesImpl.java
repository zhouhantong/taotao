package com.zht.taotao.service.impl;

import com.zht.taotao.common.pojo.EazyUiTreeNode;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.mapper.TbContentCategoryMapper;
import com.zht.taotao.mapper.TbContentMapper;
import com.zht.taotao.pojo.TbContentCategory;
import com.zht.taotao.service.TbContentCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhouhantong on 2018/4/10.
 *
 * @author 周寒通
 */
@Service
public class TbContentCategoryServicesImpl implements TbContentCategoryServices{
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;
    @Override
    public List<EazyUiTreeNode> getContentCategoryList(long parentId) {
        List<EazyUiTreeNode>result=new ArrayList<>();
       List<TbContentCategory>list= tbContentCategoryMapper.getContentCategoryList(parentId);
       for (TbContentCategory tbContentCategory:list){
           EazyUiTreeNode eazyUiTreeNode=new EazyUiTreeNode();
           eazyUiTreeNode.setId(tbContentCategory.getId());
           eazyUiTreeNode.setText(tbContentCategory.getName());
           eazyUiTreeNode.setState(tbContentCategory.getIsParent()?"closed":"open");
           result.add(eazyUiTreeNode);
       }
        return result;
    }

    @Override
    public TaotaoResult insertContentCategoryList(TbContentCategory tbContentCategory) {
        Date date=new Date();
        tbContentCategory.setParentId(tbContentCategory.getParentId());
        tbContentCategory.setName(tbContentCategory.getName());
        tbContentCategory.setCreated(date);
        tbContentCategory.setUpdated(date);
        tbContentCategory.setStatus(1);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setSortOrder(1);
        //添加记录
        tbContentCategoryMapper.insert(tbContentCategory);
        //查看父节点的isParent列是否为true,如果不是true改成true
        TbContentCategory parentCat=tbContentCategoryMapper.selectByPrimaryKey(tbContentCategory.getParentId());
        //判断是否为true
        if(!parentCat.getIsParent()){
            parentCat.setIsParent(true);
            //更新父节点
            tbContentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        return TaotaoResult.ok(tbContentCategory);
    }

    @Override
    public TaotaoResult deleteContentCategory(long id) {
        //通过id查询该分类是否为父节点
        TbContentCategory tbContentCategory=tbContentCategoryMapper.selectByPrimaryKey(id);
        //如果为父节点,删除该节点下的所有子节点
        if(tbContentCategory.getIsParent()){
            List<TbContentCategory>list=tbContentCategoryMapper.getContentCategoryList(id);
            for (TbContentCategory tb:list) {
                tbContentCategoryMapper.deleteByPrimaryKey(tb.getId());
            }
        }
        tbContentCategoryMapper.deleteByPrimaryKey(id);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateContentCategory(TbContentCategory tbContentCategory) {
        tbContentCategory.setUpdated(new Date());
        tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
        return TaotaoResult.ok();
    }
}
