package com.zht.taotao.service.aop;

import org.springframework.stereotype.Component;

/**
 * Created by zhouhantong on 2019/3/8.
 *
 * @author 周寒通
 */
@Component
public class Human implements Sleepable{
    @Override
    public void sleep() {
        System.out.println("我想睡觉了！");
    }
}
