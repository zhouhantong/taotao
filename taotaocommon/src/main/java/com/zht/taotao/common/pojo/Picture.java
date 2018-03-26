package com.zht.taotao.common.pojo;

/**
 * Created by ${zhouhantong} on 2018/3/26.
 *  富文本图片上传工具返回结果集
 * @author 周寒通
 */
public class Picture {
    private int error;
    private String url;
    private String message;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
