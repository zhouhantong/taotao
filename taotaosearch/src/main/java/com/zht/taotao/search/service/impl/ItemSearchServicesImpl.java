package com.zht.taotao.search.service.impl;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.search.dao.ItemSearchDao;
import com.zht.taotao.search.mapper.ItemSearchMapper;
import com.zht.taotao.search.pojo.ItemSeachResult;
import com.zht.taotao.search.pojo.ItemSearch;
import com.zht.taotao.search.service.ItemSearchServices;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhantong on 2018/4/18.
 *
 * @author 周寒通
 */
@Service
public class ItemSearchServicesImpl implements ItemSearchServices{
    @Autowired
    private ItemSearchMapper itemSearchMapper;
    @Autowired
    private SolrServer solrServer;
    @Autowired
    private ItemSearchDao itemSearchDao;
    @Override
    public TaotaoResult importItemList(){
        try {
            //查询商品列表
            List<ItemSearch> list = itemSearchMapper.itemSearchList();
            //把商品写入索引库
            for (ItemSearch search:list) {
                //创建一个SolrInputDocument对象
                SolrInputDocument document=new SolrInputDocument();
                document.addField("id",search.getId());
                document.addField("item_title",search.getTitle());
                document.addField("item_price",search.getPrice());
                document.addField("item_image",search.getImages());
                document.addField("item_category_name",search.getItemCatName());
                document.addField("item_desc",search.getItemDesc());
                document.addField("item_sell_point",search.getSellPoint());
                solrServer.add(document);
            }
            solrServer.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500,e.getMessage());
        }
        return TaotaoResult.ok();
    }

    /**
     * 根据搜索条件查询商品列表
     * @param queryString
     * @param page
     * @param rows
     * @return
     */
    @Override
    public ItemSeachResult itemSearchQueryList(String queryString, int page, int rows) throws Exception {
        //创建查询对象
        SolrQuery query=new SolrQuery();
        //设置查询条件
        query.setQuery(queryString);
        //设置分页参数
        query.setStart((page-1)*rows);
        query.setRows(rows);
        //设置默认查询域
        query.set("df","item_keywords");
        //设置高亮显示
        query.setHighlight(true);
        //设置高亮显示的字段
        query.addHighlightField("item_title");
        //设置高亮显示的前缀
        query.setHighlightSimplePre("<em stytle='color:red'>");
        //设置高亮显示的后缀
        query.setHighlightSimplePost("</em>");
        //执行查询条件
        ItemSeachResult result = itemSearchDao.itemSearchQuery(query);
        long totlePage=result.getSeacnCount()/rows;
        if(totlePage%rows>0){
            totlePage++;
        }
        //计算总页数
        result.setTotlePage(totlePage);
        result.setRows(rows);
        result.setCurPage(page);
        return result;
    }
}
