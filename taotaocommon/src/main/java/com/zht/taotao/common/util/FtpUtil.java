package com.zht.taotao.common.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 50194 on 2018/3/24.
 * FTP上传工具类
 */
public class FtpUtil {
    public static boolean uploadFile(FtpModer ftpModer,InputStream inputStream){
        boolean result=false;
        if(ftpModer==null){
            return result;
        }
        //创建ftp服务对象
        FTPClient ftpClient=new FTPClient();
        //创建ftp服务连接对象
        try {
            ftpClient.connect(ftpModer.getHost(),ftpModer.getPort());
            //登录
            ftpClient.login(ftpModer.getUsername(),ftpModer.getPassword());
            int reply=ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(reply)){
                ftpClient.disconnect();
                return result;
            }
            //切换到上传目录,//没有子路径
            if(ftpModer.getFilePath()==null){
                ftpClient.changeWorkingDirectory(ftpModer.getBasePath());
            }else if(!ftpClient.changeWorkingDirectory(ftpModer.getBasePath()+ftpModer.getFilePath())){
                //如果目录不存在创建目录
                String[] dirs = ftpModer.getFilePath().split("/");
                String tempPath = ftpModer.getBasePath();
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)){
                        continue;
                    }
                    tempPath += "/" + dir;
                    if (!ftpClient.changeWorkingDirectory(tempPath)) {
                        if (!ftpClient.makeDirectory(tempPath)) {
                            return result;
                        } else {
                            ftpClient.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            ftpClient.enterLocalPassiveMode();
            ftpClient.setControlEncoding("UTF-8");
            String fileName=new String(ftpModer.getFileName().getBytes("GBK"),"iso-8859-1");
            //设置上传文件的类型
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件
            if(!ftpClient.storeFile(fileName,inputStream)){
                return result;
            }
            inputStream.close();//关闭流
            ftpClient.logout();//退出ftp服务器
            result=true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return result;
    }

}
