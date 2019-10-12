package com.cf.test;

import com.cf.copyioc.BeanDefinition;
import com.cf.copyioc.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test(){
        //1.初始化工厂
        BeanFactory beanFactory = new BeanFactory();

        //2.BeanFactory注入bean
        HelloWorldService helloWorldService = new HelloWorldService();
        BeanDefinition beanDefinition = new BeanDefinition(helloWorldService);
        beanFactory.registerBeanDefination("helloWorldService",beanDefinition);

        //3.获取bean
        HelloWorldService target = (HelloWorldService) beanFactory.getBean("helloWorldService");
        target.helloService();
    }

}
