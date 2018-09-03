package com.zht.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zht.taotao.common.enums.StatusCodeEnum;
import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.util.HttpClientUtil;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.mapper.TbContentMapper;
import com.zht.taotao.pojo.TbContent;
import com.zht.taotao.service.TbContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhouhantong on 2018/4/10.
 *
 * @author 周寒通
 */
@Service
public class TbContentServicesImpl implements TbContentServices{
    @Autowired
    private TbContentMapper tbContentMapper;
    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_REDID_SYNC_URL}")
    private String REST_REDID_SYNC_URL;
    @Override
    public EazyUiResult findContentListSeach(int page,int pageSize,TbContent tbContent) {
        EazyUiResult result=new EazyUiResult();
        try {
            //设置分页参数
            PageHelper.startPage(page,pageSize);
            //查询内容管理列表
            List<TbContent> list=tbContentMapper.findContentListSeach(tbContent);
            PageInfo<TbContent>pages=new PageInfo<TbContent>(list);
            result.setTotal(pages.getTotal());
            result.setRows(pages.getList());
            result.setCode(StatusCodeEnum.SUCCESS.getCode());
            result.setMeassage(StatusCodeEnum.SUCCESS.getName());
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(StatusCodeEnum.ERROR.getCode());
            result.setMeassage(StatusCodeEnum.ERROR.getName()+e.getMessage());
        }
        return result;
    }

    @Override
    public TaotaoResult insertContent(TbContent tbContent) {
        Date date=new Date();
        tbContent.setCreated(date);
        tbContent.setUpdated(date);
        tbContentMapper.insert(tbContent);
        try {
            HttpClientUtil.doGet(REST_BASE_URL+REST_REDID_SYNC_URL+tbContent.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateContent(TbContent tbContent) {
        tbContent.setUpdated(new Date());
        tbContentMapper.updateByPrimaryKeySelective(tbContent);
        try {
            HttpClientUtil.doGet(REST_BASE_URL+REST_REDID_SYNC_URL+tbContent.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult deleteContentBatch(long[] ids) {
        TbContent tbContent= tbContentMapper.selectByPrimaryKey(ids[0]);
        tbContentMapper.deleteContentBatch(ids);
        try {
            if(tbContent!=null){
                HttpClientUtil.doGet(REST_BASE_URL+REST_REDID_SYNC_URL+tbContent.getCategoryId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TaotaoResult.ok();
    }
}
