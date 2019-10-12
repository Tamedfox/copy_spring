package com.cf.test;

import com.cf.copyioc.BeanDefinition;
import com.cf.copyioc.PropertyValue;
import com.cf.copyioc.PropertyValues;
import com.cf.copyioc.factory.AutowireCapableBeanFactory;
import com.cf.copyioc.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        //1.初始化工厂
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        //2.注册到工厂
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.cf.test.HelloWorldService");


        PropertyValue propertyValue = new PropertyValue("text","hello");
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(propertyValue);
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("helloWorldService",beanDefinition);


        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloService();
    }

}
