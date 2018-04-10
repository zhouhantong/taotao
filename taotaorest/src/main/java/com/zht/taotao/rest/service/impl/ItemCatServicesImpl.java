package com.zht.taotao.rest.service.impl;

import com.zht.taotao.mapper.TbItemCatMapper;
import com.zht.taotao.pojo.TbItemCat;
import com.zht.taotao.rest.pojo.CatNode;
import com.zht.taotao.rest.pojo.CatResult;
import com.zht.taotao.rest.service.ItemCatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouhantong on 2018/4/10.
 *
 * @author 周寒通
 */
@Service
public class ItemCatServicesImpl implements ItemCatServices{
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public CatResult findItemCatList() {
        CatResult result=new CatResult();
        result.setData(getCatList(0));
        return result;
    }

    /**
     * 查询分类列表的方法
     * @param parentId
     * @return
     */
    private List getCatList(long parentId){
        List result=new ArrayList();
       List<TbItemCat>list= itemCatMapper.selectTbItemCatByParentId(parentId);
       int count=0;
        for (TbItemCat cat:list) {
            //判断是否为父节点
            if(cat.getIsParent()){
                CatNode catNode=new CatNode();
                if(cat.getParentId()==0){
                    catNode.setName("<a href='/products/"+cat.getId()+".html'>"+cat.getName()+"</a>");
                }else {
                    catNode.setName(cat.getName());
                }
                catNode.setUrl("/products/"+cat.getId()+".html");
                catNode.setItem(getCatList(cat.getId()));
                result.add(catNode);
                count++;
                if(parentId==0&&count>=14){
                    break;
                }
            }else {//如果是叶子节点
                result.add("/products/"+cat.getId()+".html|"+cat.getName());
            }
        }
        return result;
    }
}
