package com.zht.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zht.taotao.common.enums.StatusCodeEnum;
import com.zht.taotao.common.pojo.EazyUiResult;
import com.zht.taotao.common.pojo.TbItemParamItemMap;
import com.zht.taotao.common.util.JsonUtils;
import com.zht.taotao.mapper.TbItemParamItemMapper;
import com.zht.taotao.pojo.TbItemParamItem;
import com.zht.taotao.service.TbItemParamItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhouhantong on 2018/4/8.
 *
 * @author 周寒通
 */
@Service
public class TbItemParamItemServicesImpl implements TbItemParamItemServices {
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;
    @Override
    public String showTbItemParamItemByItemId(Long id) {
        TbItemParamItem tbItemParamItem=tbItemParamItemMapper.showItemParamItemByItemId(id);
        String paramDate=tbItemParamItem.getParamData();
        List<Map>jsonToList= JsonUtils.jsonToList(paramDate, Map.class);

        StringBuffer sb=new StringBuffer();
        sb.append(			"<div class=\"Ptable\">\n");
        for (Map m1:jsonToList){
        sb.append("    <div class=\"Ptable-item\">\n");
        sb.append("        <h3>"+m1.get("group")+"</h3>\n" );
        List<Map>params=(List<Map>) m1.get("params");
        sb.append("        <dl>\n" );
            for (Map map2:params){
                sb.append("            <dt>"+map2.get("k")+"</dt><dd>"+map2.get("v")+"</dd>\n" );
            }
        sb.append("        </dl>\n" );
        sb.append("    </div>\n" );
        }
        sb.append("	</div>");
        return sb.toString();
    }

    @Override
    public EazyUiResult findTbItemParamItemList(int page, int pageSize,TbItemParamItemMap tbItemParamItemMap) {
        EazyUiResult result=new EazyUiResult();
        try {
            //设置分页参数
            PageHelper.startPage(page,pageSize);
            //查询商品规格参数列表
            List<TbItemParamItemMap>list=tbItemParamItemMapper.findItemParamItemList(tbItemParamItemMap);
            PageInfo<TbItemParamItemMap>pages=new PageInfo<TbItemParamItemMap>(list);
            result.setTotal(pages.getTotal());
            result.setCode(StatusCodeEnum.SUCCESS.getCode());
            result.setMeassage(StatusCodeEnum.SUCCESS.getName());
            result.setRows(pages.getList());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(StatusCodeEnum.ERROR.getCode());
            result.setMeassage(e.getMessage());
            return result;
        }
    }
}
