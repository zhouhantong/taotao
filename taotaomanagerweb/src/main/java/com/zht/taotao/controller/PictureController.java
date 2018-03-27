package com.zht.taotao.controller;

import com.zht.taotao.common.pojo.Picture;
import com.zht.taotao.service.PictureServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zhouhantong on 2018/3/27.
 *
 * @author 周寒通
 */
@Controller
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    private PictureServices pictureServices;
    @RequestMapping("upload")
    @ResponseBody
    public Picture uploadFile(MultipartFile uploadFile){
        Picture result=pictureServices.uploadFile(uploadFile);
        return result;
    }
}
