package com.taotao.TbItemController;

import com.zht.taotao.service.aop.Peson;
import com.zht.taotao.service.aop.Sleepable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhouhantong on 2019/3/7.
 *
 * @author 周寒通
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/applicationContext.xml",
        "classpath:config/spring-mvc.xml"
})
public class AbstractApplicationConfig {
    @Autowired(required = true)
    Peson student;

    @Autowired(required = true)
    Sleepable sleepable;
    @Test
    public void test(){
    student.said();
    }

    @Test
    public void sleep(){sleepable.sleep();}
}
