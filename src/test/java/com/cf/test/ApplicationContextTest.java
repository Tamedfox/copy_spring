package com.cf.test;

import com.cf.copyioc.beans.service.HelloWorldService;
import com.cf.copyioc.context.ApplicationContext;
import com.cf.copyioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author yihua.huang@dianping.com
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloService();
    }
}
