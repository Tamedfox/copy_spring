package com.cf.test;

import com.cf.copyioc.BeanDefinition;
import com.cf.copyioc.HelloWorldService;
import com.cf.copyioc.factory.AutowireCapableBeanFactory;
import com.cf.copyioc.factory.BeanFactory;
import com.cf.copyioc.io.ResourceLoader;
import com.cf.copyioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        //1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        //2.初始化bean并注册
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }


        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloService();
    }

}
