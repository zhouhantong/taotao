package com.zht.taotao.controller;

import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbItemParam;
import com.zht.taotao.service.TbItemParamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouhantong on 2018/4/2.
 *
 * @author 周寒通
 */
@Controller
@RequestMapping("item/param")
public class TbItemParamController {
    @Autowired
    private TbItemParamServices tbItemParamServices;
    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult getTbItemParam(@PathVariable long itemCatId){
        TaotaoResult result=tbItemParamServices.getTbItemParamByCid(itemCatId);
        return result;
    }
    @RequestMapping("/list")
    @ResponseBody
    public EazyUiResult selectTbItemParamList(Integer page,Integer rows){
        EazyUiResult result=tbItemParamServices.selectItemParamList(page,rows);
        return result;
    }
    @RequestMapping("/save/{itemCatId}")
    @ResponseBody
    public TaotaoResult insertTbItemParam(@PathVariable long itemCatId,String paramData)throws Exception{
        TbItemParam tbItemParam=new TbItemParam();
        tbItemParam.setItemCatId(itemCatId);
        tbItemParam.setParamData(paramData);
        TaotaoResult result=tbItemParamServices.insertTbItemParam(tbItemParam);
        return result;
    }
    @RequestMapping("/update/{id}")
    @ResponseBody
    public TaotaoResult updateTbItemParam(@PathVariable long id,String paramData)throws Exception{
        TbItemParam tbItemParam=new TbItemParam();
        tbItemParam.setId(id);
        tbItemParam.setParamData(paramData);
        TaotaoResult result=tbItemParamServices.updateTbItemParam(tbItemParam);
        return result;
    }
}
