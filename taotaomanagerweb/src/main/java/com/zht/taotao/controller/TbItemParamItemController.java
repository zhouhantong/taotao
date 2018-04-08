package com.zht.taotao.controller;

import com.zht.taotao.service.TbItemParamItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhouhantong on 2018/4/8.
 *
 * @author 周寒通
 */
@Controller
public class TbItemParamItemController {
    @Autowired
    private TbItemParamItemServices tbItemParamItemServices;
    @RequestMapping("showItemParamItem/{itemId}")
    public String showTbItemParamItem(@PathVariable long itemId, Model model){
        String paramData=tbItemParamItemServices.showTbItemParamItemByItemId(itemId);
        model.addAttribute("itemParam",paramData);
        return "item";
    }

}
