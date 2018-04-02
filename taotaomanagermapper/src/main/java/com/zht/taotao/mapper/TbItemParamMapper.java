package com.zht.taotao.mapper;

import com.zht.taotao.common.pojo.TbItemParamMap;
import com.zht.taotao.pojo.TbItemParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbItemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    TbItemParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemParam record);

    int updateByPrimaryKeyWithBLOBs(TbItemParam record);

    int updateByPrimaryKey(TbItemParam record);

    List<TbItemParamMap> selectItemParamList();

    TbItemParam selectItemParamByCid(Long cid);
}