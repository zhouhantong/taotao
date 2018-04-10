package com.zht.taotao.controller;

import com.zht.taotao.common.pojo.EazyUiTreeNode;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbContentCategory;
import com.zht.taotao.service.TbContentCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhouhantong on 2018/4/10.
 *
 * @author 周寒通
 */
@Controller
@RequestMapping("/content/category")
public class TbContentCategoryController {
    @Autowired
    private TbContentCategoryServices tbContentCategoryServices;
    @RequestMapping("list")
    @ResponseBody
    public List<EazyUiTreeNode> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0") long parentId){
        List<EazyUiTreeNode> result=tbContentCategoryServices.getContentCategoryList(parentId);
        return result;
    }
    @RequestMapping("create")
    @ResponseBody
    public TaotaoResult insertContentCategory(TbContentCategory tbContentCategory){
        TaotaoResult result=tbContentCategoryServices.insertContentCategoryList(tbContentCategory);
        return result;
    }
    @RequestMapping("delete")
    @ResponseBody
    public TaotaoResult deleteContentCategory(long id){
        TaotaoResult result=tbContentCategoryServices.deleteContentCategory(id);
        return result;
    }
    @RequestMapping("update")
    @ResponseBody
    public TaotaoResult updateContentCategory(TbContentCategory tbContentCategory){
        TaotaoResult result=tbContentCategoryServices.updateContentCategory(tbContentCategory);
        return TaotaoResult.ok();
    }

}
