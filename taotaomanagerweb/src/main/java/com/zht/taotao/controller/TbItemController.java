package com.zht.taotao.controller;

import com.zht.taotao.common.pojo.EaUIResult;
import com.zht.taotao.pojo.TbItem;
import com.zht.taotao.service.TbItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public EaUIResult pageTbItemList(Integer page,Integer rows){
        EaUIResult eaUIResult=tbItemServices.pageTbItemList(page,rows);
        return eaUIResult;
    }
}
