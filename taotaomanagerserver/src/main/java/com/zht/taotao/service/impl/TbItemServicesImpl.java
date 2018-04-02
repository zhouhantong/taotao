package com.zht.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zht.taotao.common.enums.StatusCodeEnum;
import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.util.IDUtil;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.mapper.TbItemDescMapper;
import com.zht.taotao.mapper.TbItemMapper;
import com.zht.taotao.pojo.TbItem;
import com.zht.taotao.pojo.TbItemDesc;
import com.zht.taotao.service.TbItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/21.
 */
@Service
public class TbItemServicesImpl implements TbItemServices{
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Override
    public TbItem selectTbTtemById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public EazyUiResult pageTbItemList(int page, int pageSize) {
        EazyUiResult eazyUiResult =new EazyUiResult();
        try{
            //设置分页参数
            PageHelper.startPage(page,pageSize);
            //查询商品列表
            List<TbItem>list=tbItemMapper.selectTbItemList();
            //取出分页参数
            PageInfo<TbItem>pageInfo=new PageInfo<TbItem>(list);
            eazyUiResult.setTotal(pageInfo.getTotal());
            eazyUiResult.setRows(pageInfo.getList());
            eazyUiResult.setCode(StatusCodeEnum.SUCCESS.getCode());
            eazyUiResult.setMeassage(StatusCodeEnum.SUCCESS.getName());
            return eazyUiResult;
        }catch (Exception e){
            eazyUiResult.setCode(StatusCodeEnum.ERROR.getCode());
            eazyUiResult.setMeassage(StatusCodeEnum.ERROR.getName()+e.getMessage());
            return eazyUiResult;
        }
    }

    /**
     * 添加商品信息
     * @param tbItem
     * @return
     * @throws Exception
     */
    @Override
    public TaotaoResult insertTbItem(TbItem tbItem,String desc)throws Exception {
        //使用自定义id生成工具定义商品ID
        long id=IDUtil.getItemId();
        tbItem.setId(id);
        //设置商品状态，1位正常，2为下架，3为删除
        tbItem.setStatus((byte)1);
        //设置商品创建时间
        tbItem.setCreated(new Date());
        //设置商品更新时间
        tbItem.setUpdated(new Date());
        tbItemMapper.insert(tbItem);
        //插入商品描述信息
        TaotaoResult taotaoResult=insertItemDesc(id,desc);
        if(StatusCodeEnum.SUCCESS.getCode()!=taotaoResult.getStatus()){
            throw new Exception();
        }
        return TaotaoResult.ok();
    }
    /**
     * 添加商品描述
     */
    private TaotaoResult insertItemDesc(long itemId,String desc){
        TbItemDesc tbItemDesc=new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        tbItemDescMapper.insert(tbItemDesc);
        return TaotaoResult.ok();
    }
}
