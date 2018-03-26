package com.zht.taotao.service.impl;

import com.zht.taotao.common.pojo.Picture;
import com.zht.taotao.common.util.FtpComUtil;
import com.zht.taotao.common.util.IDUtil;
import com.zht.taotao.service.PictureServices;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by zhouhantong on 2018/3/26.
 *
 * @author 周寒通
 */
@Service
public class PictureServicesImpl implements PictureServices{
    //通过配置文件获取ftp服务器地址
    @Value("${FTP_HOSTNAME}")
    private String hostName;
    //通过配置文件获取ftp服务器端口
    @Value("${FTP_PORT}")
    private int port;
    //通过配置文件获取ftp服务器用户名
    @Value("${FTP_USERNAME}")
    private String userName;
    //通过配置文件获取ftp服务器密码
    @Value("${FTP_PASSWORD}")
    private String password;
    //通过配置文件获取ftp服务器上传根目录
    @Value("${FTP_BASEPATH}")
    private String basePath;
    //图片上传基础路径
    @Value("${FTP_OLDURL}")
    private String oldUrl;
    @Override
    public Picture uploadFile(MultipartFile uploadFile) {
        Picture result=new Picture();
        try {
            //获取原始图片名称
            String oldFileName=uploadFile.getOriginalFilename();
            //重新定义图片名称,使用图片名生成工具
            String newFileName= IDUtil.getImageName()+oldFileName.substring(oldFileName.lastIndexOf("."));
            //使用时间工具Joda获取时间,用做filePath子文件夹名
            String filePath=new DateTime().toString("/yyyy/MM/dd");
            //图片上传
            boolean boo=FtpComUtil.uploadFile(hostName,port,userName,password,basePath,filePath,newFileName,uploadFile.getInputStream());
            //返回结果
            if(boo){
                result.setError(0);
                result.setUrl(oldUrl+filePath+"/"+newFileName);
                return result;
            }else {
                result.setError(1);
                result.setMessage("图片上传失败!");
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
            result.setError(1);
            result.setMessage("错误信息："+e.getMessage());
            return result;
        }
    }
}
