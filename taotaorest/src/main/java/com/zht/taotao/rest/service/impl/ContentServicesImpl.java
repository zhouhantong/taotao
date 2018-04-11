package com.zht.taotao.rest.service.impl;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.mapper.TbContentMapper;
import com.zht.taotao.pojo.TbContent;
import com.zht.taotao.rest.service.ContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhantong on 2018/4/11.
 *
 * @author 周寒通
 */
@Service
public class ContentServicesImpl implements ContentServices{
    @Autowired
    private TbContentMapper tbContentMapper;
    @Override
    public TaotaoResult getContentList(long categoryId) {
        try {
            TbContent tbContent=new TbContent();
            tbContent.setCategoryId(categoryId);
            List<TbContent> list=tbContentMapper.findContentListSeach(tbContent);
            return TaotaoResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500,e.getMessage());
        }
    }
}
