package com.taotao.TbItemController;

import com.zht.taotao.common.util.FtpModer;
import com.zht.taotao.common.util.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by 50194 on 2018/3/24.
 */
public class FTPTest {
    @Test
    public void testFtp()throws Exception{
        //创建ftp对象
        FTPClient ftpClient=new FTPClient();
        //创建ftp连接,默认端口21
        ftpClient.connect("192.168.88.128");
        //登录ftp服务器
        ftpClient.login("zht","zhou4236542");
        //获取上传图片的文件流
        FileInputStream fileInputStream=new FileInputStream(new File("F:/相册/QQ截图20130213005721.png"));
       //设置上传文件类型
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //设置文件上传路径
        boolean boo=ftpClient.changeWorkingDirectory("/home/zht/www/images");
        System.out.println(boo);
        //上传文件(String remote:文件名、InputStream local：文件流)
        boolean boo1=ftpClient.storeFile("QQ截图20130213005721.png",fileInputStream);
        System.out.println(boo1);
        //关闭连接
        ftpClient.logout();
    }
    @Test
    public void testFtpUtil()throws Exception{
        String path="C:\\Users/Administrator\\Desktop\\QQ截图20180226160131.png";
        FileInputStream fileInputStream=new FileInputStream(new File(path));
        //FtpModer ftpModer=new FtpModer("192.168.88.128","zht","zhou4236542","/home/zht/www/images","/2018/03/23","F:/相册/QQ截图20130213005721.png");
        FtpModer ftpModer=new FtpModer();
        ftpModer.setHost("192.168.145.128");
        ftpModer.setUsername("zht");
        ftpModer.setPassword("zht123.");
        ftpModer.setBasePath("/home/zht/www/images");
        ftpModer.setFilePath("/2018/03/26");
        ftpModer.setFileName(path);
        FtpUtil.uploadFile(ftpModer,fileInputStream);
    }
}
