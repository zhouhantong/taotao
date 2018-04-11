package com.zht.taotao.common.util;

import com.zht.taotao.common.enums.StatusCodeEnum;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouhantong on 2018/4/11.
 *  HttpClient工具类
 * @author 周寒通
 */
public class HttpClientUtil {
    /**
     * get请求,带参数
     */
    public static String doGet(String uri, Map<String,String>param){
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //初始化接收响应的对象
        String result="";
        //创建接收响应的对象
        CloseableHttpResponse response=null;
        try {
            URIBuilder builder=new URIBuilder(uri);
            if(param!=null){
                for (String key:param.keySet()) {
                    builder.addParameter(key,param.get(key));
                }
            }
            //创建get对象
            HttpGet get=new HttpGet(builder.build());
            //执行请求
            response = httpClient.execute(get);
            //判断返回状态是否为200
            if(StatusCodeEnum.SUCCESS.getCode()==response.getStatusLine().getStatusCode()){
                //转换响应数据
                result= EntityUtils.toString(response.getEntity());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭连接
            if(response!=null){
                try {
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * get请求不带参数
     * @param uri
     * @return
     */
    public static String doGet(String uri){
        return doGet(uri,null);
    }

    /**
     * post请求
     */
    public static String doPost(String uri,Map<String,String>param){
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //初始化响应对象
        CloseableHttpResponse response=null;
        //初始化转化数据
        String result="";
        try {
            List<BasicNameValuePair>pairs=new ArrayList<>();
            //模拟表单
            if(param!=null){
                for (String key:param.keySet()) {
                    pairs.add(new BasicNameValuePair(key,param.get(key)));
                }
            }
            //创建post对象
            HttpPost post=new HttpPost(uri);
            post.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
            //执行post请求
            response = httpClient.execute(post);
            if (StatusCodeEnum.SUCCESS.getCode()==response.getStatusLine().getStatusCode()){
                result=EntityUtils.toString(response.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    /**
     * 不带参数的post请求
     */
    public static String doPost(String uri){
        return doPost(uri,null);
    }
    /**
     * 传递json数据
     */
    public static String doPostJson(String uri,String json){
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //初始化响应对象
        CloseableHttpResponse response=null;
        //初始化响应数据
        String result="";
        try {
            if(json==null&&json==""){
                return "json对象的值为必填项";
            }
            //创建post对象
            HttpPost post=new HttpPost(uri);
            StringEntity entity=new StringEntity(json, ContentType.APPLICATION_JSON);
            post.setEntity(entity);
            //执行请求
            response=httpClient.execute(post);
            if(StatusCodeEnum.SUCCESS.getCode()==response.getStatusLine().getStatusCode()){
                result=EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
