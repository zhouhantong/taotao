package com.zht.taotao.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * Created by zhouhantong on 2018/3/26.
 * @author 周寒通
 * ftp上传下载工具类
 */
public class FtpComUtil {

    /**
     * Description: 向FTP服务器上传文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param userName FTP登录账号
     * @param password FTP登录密码
     * @param basePath FTP服务器基础目录
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
     * @param fileName 上传到FTP服务器上的文件名
     * @param stream 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String host, int port, String userName, String password, String basePath, String filePath, String fileName, InputStream stream){
        //返回成功还是失败,true成功
        boolean result=false;
        //创建Ftp服务对象
        FTPClient ftpClient =new FTPClient();
        try {
            //连接Ftp服务器
            ftpClient.connect(host,port);
            //登录ftp服务器
            ftpClient.login(userName,password);
            int reply=ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(reply)){
                ftpClient.disconnect();
                return result;
            }
            //切换到上传目录
            if(!ftpClient.changeWorkingDirectory(basePath+filePath)){
                //如果目录不存在
                String[] dirs=filePath.split("/");
                String tempBasePath=basePath;
                for (String dir:dirs){
                    if(StringUtils.isBlank(dir)){continue;}
                    tempBasePath+="/"+dir;
                    if(!ftpClient.changeWorkingDirectory(tempBasePath)){
                        if(!ftpClient.makeDirectory(tempBasePath)){
                            return result;
                        }else {
                            ftpClient.changeWorkingDirectory(tempBasePath);
                        }
                    }
                }
            }

            //解决上传文件中文乱码问题
            //String newFileName=new String(fileName.getBytes("GBK"),"ISO-8859-1");
            //设置上传文件的类型
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            if(!ftpClient.storeFile(fileName,stream)){
                return result;
            }else {
                stream.close();
                ftpClient.logout();
                result=true;
            }
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
    /**
     * Description: 从FTP服务器下载文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param remotePath FTP服务器上的相对路径
     * @param fileName 要下载的文件名
     * @param localPath 下载后保存到本地的路径
     * @return
     */
    public static boolean downloadFile(String host, int port, String username, String password, String remotePath,
                                       String fileName, String localPath) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.connect(host, port);
            // 登录
            ftp.login(username, password);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            // 转移到FTP服务器目录
            ftp.changeWorkingDirectory(remotePath);
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());

                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }

            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            FileInputStream in=new FileInputStream(new File("D:\\temp\\image\\gaigeming.jpg"));
            boolean flag = uploadFile("192.168.25.133", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images","/2015/01/21", "gaigeming.jpg", in);
            System.out.println(flag);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
