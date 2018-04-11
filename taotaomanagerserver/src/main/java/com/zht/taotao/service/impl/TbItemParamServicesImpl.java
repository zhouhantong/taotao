package com.zht.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zht.taotao.common.enums.StatusCodeEnum;
import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.pojo.TbItemParamMap;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.mapper.TbItemParamMapper;
import com.zht.taotao.pojo.TbItemParam;
import com.zht.taotao.service.TbItemParamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhouhantong on 2018/4/2.
 *
 * @author 周寒通
 */
@Service
public class TbItemParamServicesImpl implements TbItemParamServices{
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Override
    public TaotaoResult getTbItemParamByCid(long cid) {
        TbItemParam tbItemParam=tbItemParamMapper.selectItemParamByCid(cid);
        if(tbItemParam!=null){
            return TaotaoResult.ok(tbItemParam);
        }
        return TaotaoResult.ok();
    }

    @Override
    public EazyUiResult selectItemParamList(int page, int pageSize) {
        EazyUiResult eazyUiResult=new EazyUiResult();
        try{
            //设置分页参数
            PageHelper.startPage(page,pageSize);
            //查询商品分类规格参数列表
            List<TbItemParamMap>list=tbItemParamMapper.selectItemParamList();
            //取出分页参数
            PageInfo<TbItemParamMap> pageInfo=new PageInfo<TbItemParamMap>(list);
            eazyUiResult.setCode(StatusCodeEnum.SUCCESS.getCode());
            eazyUiResult.setMeassage(StatusCodeEnum.SUCCESS.getName());
            eazyUiResult.setRows(pageInfo.getList());
            eazyUiResult.setTotal(pageInfo.getTotal());
            return eazyUiResult;
        }catch (Exception e){
            eazyUiResult.setCode(StatusCodeEnum.ERROR.getCode());
            eazyUiResult.setMeassage(StatusCodeEnum.ERROR.getName()+e.getMessage());
            return eazyUiResult;
        }
    }

    @Override
    public TaotaoResult insertTbItemParam(TbItemParam tbItemParam)throws Exception {
        tbItemParam.setCreated(new Date());
        tbItemParam.setUpdated(new Date());
        int n=tbItemParamMapper.insert(tbItemParam);
        if(n<0){
          throw new Exception();
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateTbItemParam(TbItemParam tbItemParam) throws Exception {
        tbItemParam.setUpdated(new Date());
        int n=tbItemParamMapper.updateByPrimaryKeySelective(tbItemParam);
        if(n<0){
            throw new Exception();
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult deleteTbItemParam(long[] ids) throws Exception {
        int n=tbItemParamMapper.deleteTbItemParamList(ids);
        if(n<0){
            throw new Exception();
        }
        return TaotaoResult.ok();
    }

}
