package com.zht.taotao.mapper;

import com.zht.taotao.common.pojo.TbItemParamItemMap;
import com.zht.taotao.pojo.TbItemParamItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbItemParamItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemParamItem record);

    int insertSelective(TbItemParamItem record);

    TbItemParamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(TbItemParamItem record);

    int updateByPrimaryKey(TbItemParamItem record);

    TbItemParamItem showItemParamItemByItemId(Long itemId);

    List<TbItemParamItemMap>findItemParamItemList(TbItemParamItemMap tbItemParamItemMap);
}