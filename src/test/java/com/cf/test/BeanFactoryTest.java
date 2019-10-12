package com.cf.test;

import com.cf.copyioc.BeanDefinition;
import com.cf.copyioc.factory.AutowireCapableBeanFactory;
import com.cf.copyioc.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test(){
        //1.初始化工厂
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        //2.注册到工厂
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.cf.test.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService",beanDefinition);

        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloService();
    }

}
