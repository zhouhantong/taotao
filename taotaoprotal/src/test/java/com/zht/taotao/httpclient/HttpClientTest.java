package com.zht.taotao.httpclient;

import com.zht.taotao.common.util.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouhantong on 2018/4/11.
 *
 * @author 周寒通
 */
public class HttpClientTest {
    @Test
    public void doGet()throws Exception{
        //创建httpClient对象
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //创建一个get对象
        HttpGet get=new HttpGet("http://www.sogou.com");
        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);
        //取响应数据
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("状态码："+statusCode);
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println("响应的内容："+s);
        //关闭连接
        response.close();
        httpClient.close();
    }
    /**
     * 带查询条件
     */
    @Test
    public void doGetWithParam()throws Exception{
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建uri对象
        URIBuilder uriBuilder=new URIBuilder("http://www.sogou.com/web");
        uriBuilder.addParameter("query","周星驰");
        //创建get对象
        HttpGet get=new HttpGet(uriBuilder.build());
        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);
        //取响应数据
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("状态码："+statusCode);
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println("响应的内容："+s);
        //关闭连接
        response.close();
        httpClient.close();
    }
    /**
     * 不带参的post请求
     */
    @Test
    public void doPost()throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post对象
        HttpPost post=new HttpPost("http://localhost:8082/httpClient/post.html");
        //执行post请求
        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();
        String s=EntityUtils.toString(entity);
        System.out.println(s);
        response.close();
        httpClient.close();
    }
    /**
     * 带参post请求
     */
    @Test
    public void doPostWithParam()throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post对象
        HttpPost post=new HttpPost("http://localhost:8082/httpClient/post.html");
        //模拟表单
      /*  Map<String,String>map=new HashMap<>();
        map.put("username","张三");
        map.put("password","123456");
        String param = JsonUtils.objectToJson(map);
        System.out.println(param);
        StringEntity entity=new StringEntity(param, ContentType.APPLICATION_JSON);
        post.setEntity(entity);*/
        List<BasicNameValuePair>pairs=new ArrayList<>();
        pairs.add(new BasicNameValuePair("userName","张三"));
        pairs.add(new BasicNameValuePair("password","123456"));

        post.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
        //执行post请求
        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity entity1 = response.getEntity();
        String s=EntityUtils.toString(entity1);
        System.out.println(s);
        response.close();
        httpClient.close();
    }
}
