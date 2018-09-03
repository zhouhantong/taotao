package com.zht.taotao.mapper;

import com.zht.taotao.pojo.TbOrderShiping;

public interface TbOrderShipingMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(TbOrderShiping record);

    int insertSelective(TbOrderShiping record);

    TbOrderShiping selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(TbOrderShiping record);

    int updateByPrimaryKey(TbOrderShiping record);
}