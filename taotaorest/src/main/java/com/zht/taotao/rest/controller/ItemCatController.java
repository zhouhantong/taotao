package com.zht.taotao.rest.controller;

import com.zht.taotao.common.util.JsonUtils;
import com.zht.taotao.rest.pojo.CatResult;
import com.zht.taotao.rest.service.ItemCatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

/**
 * Created by zhouhantong on 2018/4/10.
 *
 * @author 周寒通
 */
@Controller
public class ItemCatController {
    @Autowired
    private ItemCatServices itemCatServices;
    //@RequestMapping(value = "/itemcat/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
   /* @RequestMapping("/itemcat/list")
    @ResponseBody
    public String findItemCatList(String callBack){
        CatResult catResult=itemCatServices.findItemCatList();
        String json= JsonUtils.objectToJson(catResult);
        String result=callBack+"("+json+");";
        return result;
    }*/

    /**
     * 使用MappingJacksonValue转换json对象，返回回调函数，Spring4.1以上版本功能
     * @param callBack
     * @return
     */
    @RequestMapping("/itemcat/list")
    @ResponseBody
    public Object findItemCatList(String callBack){
        CatResult catResult=itemCatServices.findItemCatList();
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(catResult);
        mappingJacksonValue.setJsonpFunction(callBack);
        return mappingJacksonValue;
    }
}
