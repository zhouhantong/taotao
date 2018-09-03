package com.zht.taotao.common.pojo;

import java.util.Date;

/**
 * Created by zhouhantong on 2018/4/2.
 *
 * @author 周寒通
 */
public class TbItemParamMap {
    /**商品类目规格id*/
    private Long id;
    /**商品类目名id*/
    private Long itemCatId;
    /**商品类目规格创建时间*/
    private Date created;
    /**商品类目规格修改时间*/
    private Date updated;
    /**商品类目规格参数*/
    private String paramData;
    /**商品类目名称*/
    private String itemCatName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getItemCatName() {
        return itemCatName;
    }

    public void setItemCatName(String itemCatName) {
        this.itemCatName = itemCatName;
    }
}
