package com.zht.taotao.service.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by zhouhantong on 2019/3/8.
 *
 * @author 周寒通
 */
@Component("advisorTest")
public class AdvisorTest implements MethodBeforeAdvice, AfterReturningAdvice{
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("起床后要穿衣服");
    }
    @Before("execution(* com.zht.taotao.service.aop.Human.sleep(..))")
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("睡觉前要脱衣服！");
    }
}
