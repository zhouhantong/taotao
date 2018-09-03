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

import java.io.UnsupportedEncodingException;
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
    public EazyUiResult pageTbItemList(Integer page, Integer rows,TbItem tbItem){
        EazyUiResult result= null;
        try {
            result = new EazyUiResult();
            if(tbItem.getTitle()!=null&&tbItem.getTitle()!=""){
                tbItem.setTitle(new String(tbItem.getTitle().getBytes("iso-8859-1"),"utf-8"));
            }
            result =tbItemServices.pageTbItemList(page,rows,tbItem);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createTbItem(TbItem tbItem,String desc,String itemParams)throws Exception{
        TaotaoResult taotaoResult=tbItemServices.insertTbItem(tbItem,desc,itemParams);
        return taotaoResult;
    }
}
