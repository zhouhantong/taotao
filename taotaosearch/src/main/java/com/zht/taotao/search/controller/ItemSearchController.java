package com.zht.taotao.search.controller;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.search.pojo.ItemSeachResult;
import com.zht.taotao.search.service.ItemSearchServices;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouhantong on 2018/4/18.
 * 把商品列表导入索引库
 * @author 周寒通
 */
@Controller
@RequestMapping("/manager")
public class ItemSearchController {
    @Autowired
    private ItemSearchServices searchServices;
    @RequestMapping("/import")
    @ResponseBody
    public TaotaoResult importItemSeachList(){
        TaotaoResult result = searchServices.importItemList();
        return result;
    }
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public TaotaoResult itemSearchQueryList(@RequestParam("q") String queryString,
                                            @RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "60") Integer rows){
        if(StringUtils.isBlank(queryString)){
            return TaotaoResult.build(400,"查询条件不能为空");
        }
        try {
            queryString=new String(queryString.getBytes("iso-8859-1"),"utf-8");
            ItemSeachResult result = searchServices.itemSearchQueryList(queryString, page, rows);
            return TaotaoResult.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500,e.getMessage());
        }
    }
}
