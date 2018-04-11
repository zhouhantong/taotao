package com.zht.taotao.rest.controller;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbContent;
import com.zht.taotao.rest.service.ContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouhantong on 2018/4/11.
 *
 * @author 周寒通
 */
@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentServices contentServices;
    @RequestMapping("/list/{categoryId}")
    @ResponseBody
    public TaotaoResult getContentList(@PathVariable long categoryId){
        TaotaoResult result = contentServices.getContentList(categoryId);
        return result;
    }
}
