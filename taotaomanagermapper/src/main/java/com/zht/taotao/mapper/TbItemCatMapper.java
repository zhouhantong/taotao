package com.zht.taotao.mapper;

import com.zht.taotao.pojo.TbItemCat;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TbItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);

    List<TbItemCat> selectTbItemCatByParentId(Long parentId);
}