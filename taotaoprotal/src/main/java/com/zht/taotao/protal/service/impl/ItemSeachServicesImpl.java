package com.zht.taotao.protal.service.impl;

import com.zht.taotao.common.util.HttpClientUtil;
import com.zht.taotao.common.util.JsonUtils;
import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.protal.pojo.ItemSeachResult;
import com.zht.taotao.protal.service.ItemSeachServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouhantong on 2018/4/18.
 *
 * @author 周寒通
 */
@Service
public class ItemSeachServicesImpl implements ItemSeachServices{
    @Value("${SEARCH_BASE_URL}")
    private String SEARCH_BASE_URL;
    @Value("${SEARCH_URL}")
    private String SEARCH_URL;

    @Override
    public ItemSeachResult itemSearchQueryList(String queryString, int page) {
        Map<String,String>param=new HashMap<>();
        param.put("q",queryString);
        param.put("page",page+"");
        try {
            String json = HttpClientUtil.doGet(SEARCH_BASE_URL + SEARCH_URL, param);
            TaotaoResult result = TaotaoResult.formatToPojo(json, ItemSeachResult.class);
            if(result.getStatus()==200){
                return (ItemSeachResult) result.getData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
