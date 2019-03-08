package com.zht.taotao.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by zhouhantong on 2019/3/7.
 *  Aop测试
 * @author 周寒通
 */
@Component
@Aspect
public class AspectJTest {
    /**
     * 例如定义切入点表达式  execution (* com.sample.service.impl..*.*(..))
     * execution()是最常用的切点函数，其语法如下所示：
     *
     *  整个表达式可以分为五个部分：
     *
     *  1、execution(): 表达式主体。
     *
     *  2、第一个*号：表示返回类型，*号表示所有的类型。
     *
     *  3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
     *
     *  4、第二个*号：表示类名，*号表示所有的类。
     *
     *  5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     */
    @Pointcut(value = "execution(* com.zht.taotao.service.aop.Student.said(..))")
    public void test(){}
    @Before("test()")
    public void before(){
        System.out.println("before test .....");
    }
    @After("test()")
    public void after(){
        System.out.println("after test ......");
    }

    @Around("test()")
    public Object around(ProceedingJoinPoint p){
        System.out.println("before1");
        Object o=null;
        try {
            o=p.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }
}
