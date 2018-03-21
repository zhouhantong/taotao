package com.zht.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/3/21.
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
}
