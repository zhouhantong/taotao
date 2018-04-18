package com.zht.taotao.search.mapper;

import com.zht.taotao.search.pojo.ItemSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouhantong on 2018/4/18.
 *
 * @author 周寒通
 */
@Repository
public interface ItemSearchMapper {
    List<ItemSearch> itemSearchList();
}
