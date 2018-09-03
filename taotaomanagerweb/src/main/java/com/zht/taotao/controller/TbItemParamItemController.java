package com.zht.taotao.controller;

import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.pojo.TbItemParamItemMap;
import com.zht.taotao.service.TbItemParamItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhouhantong on 2018/4/8.
 *
 * @author 周寒通
 */
@Controller
@RequestMapping("/itemParamItem")
public class TbItemParamItemController {
    @Autowired
    private TbItemParamItemServices tbItemParamItemServices;
    @RequestMapping("/showItemParamItem/{itemId}")
    public String showTbItemParamItem(@PathVariable long itemId, Model model){
        String paramData=tbItemParamItemServices.showTbItemParamItemByItemId(itemId);
        model.addAttribute("itemParam",paramData);
        return "item-Param-item";
    }
    @RequestMapping(value = "/list",produces = { "text/html;charset=UTF-8"})
    @ResponseBody
    public EazyUiResult findItemParamItemList(Integer page, Integer rows, TbItemParamItemMap tbItemParamItemMap){
        EazyUiResult result=new EazyUiResult();
        try {
            if(tbItemParamItemMap.getItemName()!=null&&tbItemParamItemMap.getItemName()!=""){
                tbItemParamItemMap.setItemName(new String(tbItemParamItemMap.getItemName().getBytes("iso-8859-1"),"utf-8"));
            }
            result=tbItemParamItemServices.findTbItemParamItemList(page,rows,tbItemParamItemMap);
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return result;
        }

    }

}
