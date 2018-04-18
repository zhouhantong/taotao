package com.zht.taotao.search.dao.impl;

import com.zht.taotao.search.dao.ItemSearchDao;
import com.zht.taotao.search.pojo.ItemSeachResult;
import com.zht.taotao.search.pojo.ItemSearch;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouhantong on 2018/4/18.
 *
 * @author 周寒通
 */
@Repository
public class ItemSearchDaoImpl  implements ItemSearchDao{
    @Autowired
    private SolrServer solrServer;
    @Override
    public ItemSeachResult itemSearchQuery(SolrQuery solrQuery) throws Exception {
        //创建返回结果对象
        ItemSeachResult result=new ItemSeachResult();
        //获取查询信息
        QueryResponse query =solrServer.query(solrQuery);
        //取商品列表
        SolrDocumentList results = query.getResults();
        //取高亮显示
        Map<String, Map<String, List<String>>> highlighting = query.getHighlighting();
        List<ItemSearch> list=new ArrayList<>();
        for (SolrDocument document:results) {
            ItemSearch itemSearch=new ItemSearch();
            itemSearch.setId((String) document.get("id"));
            //取高亮显示的结果
            String title="";
            List<String> strs = highlighting.get(document.get("id")).get("item_title");
            if(strs!=null&&strs.size()>0){
                title=strs.get(0);
            }else {
                title=(String) document.get("item_title");
            }
            itemSearch.setImages((String) document.get("item_image"));
            itemSearch.setItemCatName((String) document.get("item_category_name"));
            itemSearch.setPrice((Long) document.get("item_price"));
            itemSearch.setTitle(title);
            itemSearch.setSellPoint((String) document.get("item_sell_point"));
            list.add(itemSearch);
        }

        result.setList(list);
        result.setSeacnCount(results.getNumFound());
        return result;
    }
}
