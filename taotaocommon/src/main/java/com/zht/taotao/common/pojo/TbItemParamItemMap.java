package com.zht.taotao.common.pojo;

import java.util.Date;

/**
 * Created by zhouhantong on 2018/4/9.
 *  商品规格参数
 * @author 周寒通
 */
public class TbItemParamItemMap {
    /**商品规格参数id*/
    private Long id;
    /**商品id*/
    private Long itemId;
    /**商品规名称*/
    private String itemName;
    /**商品规格参数*/
    private String paramData;
    /**商品规格参数创建时间*/
    private Date created;
    /**商品规格参数修改时间*/
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
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
}
