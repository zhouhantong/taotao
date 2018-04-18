package com.zht.taotao.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ShardParams;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

/**
 * Created by zhouhantong on 2018/4/18.
 *  测试solrJ
 * @author 周寒通
 */
public class SolrJTest {
    /**
     * 添加/修改索引库
     * @throws Exception
     */
    @Test
    public void addDocument()throws Exception{
        //创建连接
        SolrServer solrServer=new HttpSolrServer("http://192.168.145.128:8080/solr");
        //创建一个文档对象
        SolrInputDocument document=new SolrInputDocument();
        //添加文档内容
        document.addField("id",1);
        document.addField("item_title","测试商品4");
        document.addField("item_price",6666);
        //把文档对象写入索引库
        solrServer.add(document);
        //提交
        solrServer.commit();
    }
    /**
     * 删除索引库
     */
    @Test
    public void delDocument()throws Exception{
        //创建连接
        SolrServer solrServer=new HttpSolrServer("http://192.168.145.128:8080/solr");
        solrServer.deleteById("1");
        solrServer.commit();
    }
    @Test
    public void queryDocument()throws Exception{
        //创建连接
        SolrServer solrServer=new HttpSolrServer("http://192.168.145.128:8080/solr");
        SolrQuery query=new SolrQuery();
        query.setQuery("item_title:测试");

        QueryResponse response = solrServer.query(query);
        SolrDocumentList results = response.getResults();
        System.out.println("总数据量:"+results.getNumFound());
        for (SolrDocument s:results) {
            System.out.println(s.get("id"));
            System.out.println(s.get("item_title"));
        }

    }
}
