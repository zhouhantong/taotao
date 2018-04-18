package com.zht.taotao.search.dao;

import com.zht.taotao.common.util.TaotaoResult;
import com.zht.taotao.search.pojo.ItemSeachResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * Created by zhouhantong on 2018/4/18.
 *  商品查询dao
 * @author 周寒通
 */
public interface ItemSearchDao {
    ItemSeachResult itemSearchQuery(SolrQuery solrQuery)throws Exception;
}
