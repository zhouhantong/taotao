package com.zht.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zht.taotao.common.pojo.EaUIResult;
import com.zht.taotao.mapper.TbItemMapper;
import com.zht.taotao.pojo.TbItem;
import com.zht.taotao.service.TbItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/21.
 */
@Service
public class TbItemServicesImpl implements TbItemServices{
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public TbItem selectTbTtemById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public EaUIResult pageTbItemList(int page, int pageSize) {
        EaUIResult eaUIResult=new EaUIResult();
        try{
            //设置分页参数
            PageHelper.startPage(page,pageSize);
            //查询商品列表
            List<TbItem>list=tbItemMapper.selectTbItemList();
            //取出分页参数
            PageInfo<TbItem>pageInfo=new PageInfo<TbItem>(list);
            eaUIResult.setTotal(pageInfo.getTotal());
            eaUIResult.setRows(pageInfo.getList());
            eaUIResult.setCode("00");
            eaUIResult.setMeassage("请求成功！");
            return eaUIResult;
        }catch (Exception e){
            e.printStackTrace();
            eaUIResult.setRows(new ArrayList<TbItem>());
            eaUIResult.setCode("99");
            eaUIResult.setMeassage("请求失败："+e.getMessage());
            return eaUIResult;
        }
    }
}
