package com.zht.taotao.service.impl;

import com.zht.taotao.mapper.TbItemMapper;
import com.zht.taotao.pojo.TbItem;
import com.zht.taotao.service.TbItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/3/21.
 */
@Service
public class TbItemServicesImpl implements TbItemServices{
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public TbItem selectTbTtemById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }
}
