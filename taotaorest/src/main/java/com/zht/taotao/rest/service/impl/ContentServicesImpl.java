package com.zht.taotao.rest.service.impl;

import com.zht.taotao.common.util.JsonUtils;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.mapper.TbContentMapper;
import com.zht.taotao.pojo.TbContent;
import com.zht.taotao.rest.dao.JedisClient;
import com.zht.taotao.rest.service.ContentServices;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Autowired
    private JedisClient jedisClient;
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;
    /**
     * 根据内容分类id查询内容列表，使用redis缓存
     * @param categoryId
     * @return
     */
    @Override
    public TaotaoResult getContentList(long categoryId) {
        //从缓存中取数据
        try {
           String result=jedisClient.hget(INDEX_CONTENT_REDIS_KEY,categoryId+"");
            if ( StringUtils.isNotBlank(result)) {
                //把取出的数据转换成list集合
                List<TbContent> tbContents = JsonUtils.jsonToList(result, TbContent.class);
                return TaotaoResult.ok(tbContents);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            //首次因为没有缓存，得先从数据库中查询出来，然后存进缓存中
            TbContent tbContent=new TbContent();
            tbContent.setCategoryId(categoryId);
            List<TbContent> list=tbContentMapper.findContentListSeach(tbContent);
            try {
                //使用json工具把list结果转换成字符串
                String result = JsonUtils.objectToJson(list);
                jedisClient.hset(INDEX_CONTENT_REDIS_KEY,categoryId+"",result);
            }catch (Exception e){
                e.printStackTrace();
            }
            return TaotaoResult.ok(list);
    }
}
