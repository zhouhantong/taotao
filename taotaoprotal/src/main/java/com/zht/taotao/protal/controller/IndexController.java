package com.zht.taotao.protal.controller;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.protal.service.ContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouhantong on 2018/4/9.
 *
 * @author 周寒通
 */
@Controller
public class IndexController {
    @Autowired
    private ContentServices contentServices;
    @RequestMapping("/index")
    public String showIndex(Model model){
        String json = contentServices.getContentList();
        model.addAttribute("ad1",json);
        return "index";
    }

    @RequestMapping(value = "/httpClient/post",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult testHttoClientPost(String username,String password){
        Map<String,String>map=new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return TaotaoResult.ok(map);
    }
}
