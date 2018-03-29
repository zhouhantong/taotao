package com.zht.taotao.controller;

import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbItem;
import com.zht.taotao.service.TbItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/3/21.
 */
@Controller
@RequestMapping("/item")
public class TbItemController {
    @Autowired()
    private TbItemServices tbItemServices;
    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem selectTbItemById(@PathVariable Long itemId){
        TbItem tbItem=tbItemServices.selectTbTtemById(itemId);
        return tbItem;
    }
    @RequestMapping("/list")
    @ResponseBody
    public EazyUiResult pageTbItemList(Integer page, Integer rows){
        EazyUiResult eazyUiResult =tbItemServices.pageTbItemList(page,rows);
        return eazyUiResult;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createTbItem(TbItem tbItem,String desc)throws Exception{
        TaotaoResult taotaoResult=tbItemServices.insertTbItem(tbItem,desc);
        return taotaoResult;
    }
}
