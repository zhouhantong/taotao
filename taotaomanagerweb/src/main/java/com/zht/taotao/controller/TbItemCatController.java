package com.zht.taotao.controller;

import com.zht.taotao.common.pojo.EazyUiTreeNode;
import com.zht.taotao.service.TbItemCatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */
@Controller
@RequestMapping("/item/cat")
public class TbItemCatController {
    @Autowired
    private TbItemCatServices tbItemCatServices;
    @RequestMapping("/list")
    @ResponseBody
    public List<EazyUiTreeNode> getCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        List<EazyUiTreeNode>list=tbItemCatServices.getCatList(parentId);
        return list;
    }
}
