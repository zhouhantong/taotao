package com.zht.taotao.common.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;


/**
 * Created by zhouhantong on 2018/3/27.
 * @author 周寒通
 * 淘淘商城通用响应数据
 */
public class TaotaoResult {
    /**json对象*/
    private static final ObjectMapper MAPPER=new ObjectMapper();
    /**响应状态*/
    private Integer status;
    /**响应消息*/
    private String msg;
    /**响应数据*/
    private Object data;
    public TaotaoResult (){}

    /**
     * 带返回数据的响应结果
     * @param data
     * @return
     */
    public static TaotaoResult ok(Object data){
        return new TaotaoResult(data);
    }

    /**
     * 不带返回数据的响应结果
     * @return
     */
    public static TaotaoResult ok(){
        return new TaotaoResult(null);
    }

    /**
     *  自定义返回结果,带数据
     * @param data
     * @param msg
     * @param data
     */
    public static TaotaoResult build(Integer status,String msg,Object data){
        return new TaotaoResult(status,msg,data);
    }

    /**
     * 自定义返回结果，不带数据
     * @param status
     * @param msg
     * @return
     */
    public static TaotaoResult build(Integer status,String msg){
        return new TaotaoResult(status,msg,null);
    }

    /**
     * 将json结果集转为TaotaoResult
     * @param jsonData
     * @param clazz
     */
    public static TaotaoResult formatToPojo(String jsonData, Class<?>clazz){

            try {
                if(clazz==null){
                return MAPPER.readValue(jsonData,TaotaoResult.class);
                }
                JsonNode jsonNode=MAPPER.readTree(jsonData);
                JsonNode data=jsonNode.get("data");
                Object obj=null;
                if(clazz!=null){
                    if(data.isObject()){
                        obj=MAPPER.readValue(data.traverse(),clazz);
                    }else if(data.isTextual()){
                        obj=MAPPER.readValue(data.asText(),clazz);
                    }
                }
                return build(jsonNode.get("status").intValue(),jsonNode.get("msg").textValue(),obj);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
    }
    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static TaotaoResult format(String json) {
        try {
            return MAPPER.readValue(json, TaotaoResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static TaotaoResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    public TaotaoResult(Integer status,String msg,Object data){
        this.status=status;
        this.msg=msg;
        this.data=data;
    }

    public TaotaoResult(Object data){
        this.status=200;
        this.msg="OK";
        this.data=data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
