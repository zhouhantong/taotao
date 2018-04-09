package com.taotao.TbItemController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zht.taotao.mapper.TbItemCatMapper;
import com.zht.taotao.mapper.TbItemMapper;
import com.zht.taotao.pojo.TbItem;
import com.zht.taotao.pojo.TbItemCat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
public class TestTbItem {
    @Test
    public void pageTbItem(){
        //创建一个spring容器
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        //从spring容器中取出对应的mapper对象
        TbItemMapper tbItemMapper=context.getBean(TbItemMapper.class);
        //使用PageHelper插件设置当前页和每页显示的记录数
        PageHelper.startPage(2,5);
        //查询商品列表
        TbItem tbItem=null;
        List<TbItem>list=tbItemMapper.selectTbItemList(tbItem);
        //遍历商品列表
        for (TbItem tb:list) {
            System.out.println(tb.getTitle());
        }
        //使用PageInfo对象显示分页信息
        PageInfo<TbItem>page=new PageInfo<TbItem>(list);
        System.out.println("总页数："+page.getPages()+"/总记录数："+page.getTotal()
        +"/当前页："+page.getPageNum()+"/每页记录数"+page.getPageSize());

    }
    @Test
    public void getCatList(){
        //创建一个spring容器
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        //从spring容器中取出对应的mapper对象
        TbItemCatMapper tbItemCatMapper=context.getBean(TbItemCatMapper.class);
        long parentId=0;
        List<TbItemCat>list=tbItemCatMapper.selectTbItemCatByParentId(parentId);
        for (TbItemCat t:list) {
            System.out.println(t.getIsParent()+"==="+t.getParentId()+"===="+t.getName());
        }
    }
}
