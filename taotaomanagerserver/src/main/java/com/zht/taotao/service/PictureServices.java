package com.zht.taotao.service;

import com.zht.taotao.common.pojo.Picture;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zhouhantong on 2018/3/26.
 *
 * @author 周寒通
 */
public interface PictureServices {
    Picture uploadFile(MultipartFile uploadFile);
}
