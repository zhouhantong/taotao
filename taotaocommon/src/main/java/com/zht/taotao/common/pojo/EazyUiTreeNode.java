package com.zht.taotao.common.pojo;

/**
 * Created by Administrator on 2018/3/22.
 * EazyUi树形属性封装
 */
public class EazyUiTreeNode {
    /**节点id*/
    private long id;
    /**节点名称*/
    private String text;
    /**节点状态：closed(关闭)、open(打开)*/
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
