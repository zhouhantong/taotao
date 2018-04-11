package com.zht.taotao.protal.controller;

import com.zht.taotao.common.util.TaotaoResult;
import org.springframework.stereotype.Controller;
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
    @RequestMapping("/index")
    public String showIndex(){
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
