package com.zht.taotao.protal.pojo;


import java.util.List;

/**
 * Created by zhouhantong on 2018/4/18.
 *  商品信息返回对象
 * @author 周寒通
 */
public class ItemSeachResult {
    //商品列表
    private List<ItemSearch> list;
    //总记录数
    private long seacnCount;
    //当前页
    private long curPage;
    //每页显示的记录数
    private long rows;
    //总页数
    private long totlePage;

    public long getTotlePage() {
        return totlePage;
    }

    public void setTotlePage(long totlePage) {
        this.totlePage = totlePage;
    }

    public List<ItemSearch> getList() {
        return list;
    }

    public void setList(List<ItemSearch> list) {
        this.list = list;
    }

    public long getSeacnCount() {
        return seacnCount;
    }

    public void setSeacnCount(long seacnCount) {
        this.seacnCount = seacnCount;
    }

    public long getCurPage() {
        return curPage;
    }

    public void setCurPage(long curPage) {
        this.curPage = curPage;
    }

    public long getRows() {
        return rows;
    }

    public void setRows(long rows) {
        this.rows = rows;
    }
}
