package com.zht.taotao.common.util;

import java.util.Random;

/**
 * Created by zhouhantong on 2018/3/26.
 * @author 周寒通
 * 各种ID生成策略
 */
public class IDUtil {
    /**
     * 图片名生成
     */
    public static String getImageName(){
        //取当前时间的长整形值包含毫秒
        long millis=System.currentTimeMillis();
        //long millis1=System.nanoTime(); 纳秒
        //取3位随机数
        //Random random=new Random();
        //如果不足三位前面补0
        // String end=String.format("%03d",end)
        //生成3位随机数(字母加数字组合)
        String end=getStringRandom(3);
        String str=millis+end;
        return str;
    }

    public static void main(String[] args) {
        System.out.println(getStringRandom(3));
        System.out.println(getImageName());
    }

    /**
     * 生成随机数字和字母
     * @param length
     * @return
     */
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

}
