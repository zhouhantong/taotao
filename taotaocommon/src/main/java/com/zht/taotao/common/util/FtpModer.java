package com.zht.taotao.common.util;

import java.io.InputStream;

/**
 * Created by 50194 on 2018/3/24.
 */
public class FtpModer {
    /**服务器hostname*/
    private  String host;
    /**服务器端口号*/
    private  int port=21;
    /**登录服务器的用户名*/
    private  String username;
    /**登录服务器的密码*/
    private  String password;
    /**上传文件的基础路径*/
    private  String basePath;
    /**FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath*/
    private  String filePath;
    /**上传到FTP服务器上的文件名,可以自己定义,也可以使用原文件名*/
    private  String fileName;

    public FtpModer(){}
    public FtpModer(String host,int port,String username,String password,String basePath,String filePath,String fileName){
        this.host=host;
        this.port=port;
        this.username=username;
        this.password=password;
        this.basePath=basePath;
        this.filePath=filePath;
        this.fileName=fileName;
    }
    public FtpModer(String host,String username,String password,String basePath,String fileName){
        this.host=host;
        this.username=username;
        this.password=password;
        this.basePath=basePath;
        this.fileName=subFilePath(fileName);
    }
    public FtpModer(String host,String username,String password,String basePath,String filePath,String fileName){
        this.host=host;
        this.username=username;
        this.password=password;
        this.basePath=basePath;
        this.filePath=filePath;
        this.fileName=subFilePath(fileName);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName=subFilePath(fileName);
    }
    /**
     * 截取上传文件的文件名
     * @param filePath
     * @return
     */
    public static String subFilePath(String filePath){
        String file=filePath.replaceAll("\\\\","/");
        System.out.println(file);
        String[] fileName=file.split("/");
        String ress="";
        if(filePath.length()>0&&fileName!=null){
            for (String res: fileName) {
                ress=res;
            }
        }else {
            ress=filePath;
        }
        return ress;
    }

    public static void main(String[] args) {
        //String res=subFilePath("F:/相册/天津/0A93EE9A-C9A0-4DF1-AE87-6B5C30DD779B.JPG");
        String res=subFilePath("hello.jpg");
        System.out.println(res);
    }
}
