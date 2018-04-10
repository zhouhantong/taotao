package com.zht.taotao.controller;

import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbContent;
import com.zht.taotao.service.TbContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouhantong on 2018/4/10.
 *
 * @author 周寒通
 */
@Controller
@RequestMapping("/content")
public class TbContentController {
    @Autowired
    private TbContentServices tbContentServices;
    @RequestMapping("/query/list")
    @ResponseBody
    public EazyUiResult findContentListSeach(int page, int rows, TbContent tbContent){
        EazyUiResult result=tbContentServices.findContentListSeach(page,rows,tbContent);
        return result;
    }
    @RequestMapping("save")
    @ResponseBody
    public TaotaoResult insertContent(TbContent tbContent){
        TaotaoResult result=tbContentServices.insertContent(tbContent);
        return result;
    }
    @RequestMapping("edit")
    @ResponseBody
    public TaotaoResult updateContent(TbContent tbContent){
        TaotaoResult result=tbContentServices.updateContent(tbContent);
        return result;
    }
    @RequestMapping("delete")
    @ResponseBody
    public TaotaoResult deleteContent(long[]ids){
        TaotaoResult result=tbContentServices.deleteContentBatch(ids);
        return result;
    }
}
