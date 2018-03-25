package com.zht.taotao.common.util;

import java.io.InputStream;

/**
 * Created by 50194 on 2018/3/24.
 */
public class FtpModer {
    //服务器hostname
    private  String host;
    //服务器端口号
    private  int post=21;
    //登录服务器的用户名
    private  String username;
    //登录服务器的密码
    private  String password;
    //上传文件的基础路径
    private  String basePath;
    //FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
    private  String filePath;
    //上传到FTP服务器上的文件名
    private  String fileName;

    public FtpModer(){}
    public FtpModer(String host,int post,String username,String password,String basePath,String filePath,String fileName){
        this.host=host;
        this.post=post;
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

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
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
        this.fileName = fileName;
    }
    /**
     * 截取上传文件的文件名
     * @param filePath
     * @return
     */
    public static String subFilePath(String filePath){
        String[] fileName=filePath.split("/");
        String ress="";
        for (String res: fileName) {
            ress=res;
        }
        return ress;
    }

    public static void main(String[] args) {
        String res=subFilePath("F:/相册/天津/0A93EE9A-C9A0-4DF1-AE87-6B5C30DD779B.JPG");
        System.out.println(res);
    }
}
