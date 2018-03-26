package com.zht.taotao.common.pojo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 * 通用EasyUI结果集
 */
public class EaUIResult {
    private Long total;
    private List<?> rows;
    private String meassage;
    private String code;
    public EaUIResult(){}
    public EaUIResult(Long total,List<?> rows){
    this.total=total;
    this.rows=rows;
    }
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public String getMeassage() {
        return meassage;
    }

    public void setMeassage(String meassage) {
        this.meassage = meassage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
