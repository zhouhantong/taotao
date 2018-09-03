package com.zht.taotao.rest.controller;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.rest.service.RedisSynchronizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouhantong on 2018/4/17.
 *
 * @author 周寒通
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisSyncController {
    @Autowired
    private RedisSynchronizationServices redisSynchronizationServices;
    @RequestMapping("/content/{contentId}")
    @ResponseBody
    public TaotaoResult syncContent(@PathVariable long contentId){
        TaotaoResult result=redisSynchronizationServices.syncContent(contentId);
        return result;
    }
}
