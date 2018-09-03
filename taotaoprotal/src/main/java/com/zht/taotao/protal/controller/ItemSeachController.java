package com.zht.taotao.protal.controller;

import com.zht.taotao.protal.pojo.ItemSeachResult;
import com.zht.taotao.protal.service.ItemSeachServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhouhantong on 2018/4/18.
 *
 * @author 周寒通
 */
@Controller
public class ItemSeachController {
    @Autowired
    private ItemSeachServices itemSeachServices;
    @RequestMapping("search")
    public String itemSearchQueryList(@RequestParam("q") String queryString,@RequestParam(defaultValue = "1") Integer page, Model model){
        try {
            String query=new String(queryString.getBytes("iso-8859-1"),"utf-8");
            ItemSeachResult itemSeachResult = itemSeachServices.itemSearchQueryList(query, page);
            model.addAttribute("itemList",itemSeachResult.getList());
            model.addAttribute("totalPages",itemSeachResult.getTotlePage());
            model.addAttribute("query",query);
            model.addAttribute("page",page);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "search";
    }
}
