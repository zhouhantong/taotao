package com.zht.taotao.service.aop;

import org.springframework.stereotype.Component;

/**
 * Created by zhouhantong on 2019/3/7.
 *
 * @author 周寒通
 */
@Component("student")
public class Student implements Peson{
    @Override
    public void said() {
        System.out.println("苦逼得程序员");
    }
}
