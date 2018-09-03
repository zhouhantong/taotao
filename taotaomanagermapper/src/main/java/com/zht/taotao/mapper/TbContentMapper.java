package com.zht.taotao.mapper;

import com.zht.taotao.pojo.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKeyWithBLOBs(TbContent record);

    int updateByPrimaryKey(TbContent record);

    List<TbContent> findContentListSeach(TbContent tbContent);

    int deleteContentBatch(long[]ids);
}