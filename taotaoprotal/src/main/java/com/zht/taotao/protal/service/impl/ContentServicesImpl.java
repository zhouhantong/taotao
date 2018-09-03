package com.zht.taotao.protal.service.impl;

import com.zht.taotao.common.util.HttpClientUtil;
import com.zht.taotao.common.util.JsonUtils;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.pojo.TbContent;
import com.zht.taotao.protal.service.ContentServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouhantong on 2018/4/12.
 *
 * @author 周寒通
 */
@Service
public class ContentServicesImpl implements ContentServices{
    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_INDEX_AD_URL}")
    private String REST_INDEX_AD_URL;
    /**
     * 调用服务层，查询内容列表
     * @return
     */
    @Override
    public String getContentList() {
        //调用服务层
        String result= HttpClientUtil.doGet(REST_BASE_URL+REST_INDEX_AD_URL);
        try {
            //把字符串转换成TaotaoResult
            TaotaoResult taotaoResult =  TaotaoResult.formatToList(result,TbContent.class);
            List<TbContent> list= (List<TbContent>) taotaoResult.getData();
            //创建一个jsp页面所需要的pojo列表，使用map
            List<Map>mapList=new ArrayList<>();
            for (TbContent tb:list) {
                Map map=new HashMap();
                map.put("src",tb.getPic());
                map.put("height",240);
                map.put("width",670);
                map.put("srcB",tb.getPic2());
                map.put("widthB",550);
                map.put("heigthB",240);
                map.put("href",tb.getUrl());
                map.put("alt",tb.getSubTitle());
                mapList.add(map);
            }
            //把内容列表转换成json格式的数据
            String json= JsonUtils.objectToJson(mapList);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
