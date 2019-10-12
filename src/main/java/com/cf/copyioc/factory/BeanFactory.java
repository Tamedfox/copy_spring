package com.cf.copyioc.factory;


import com.cf.copyioc.BeanDefinition;

/**
 * beanfactory替换为接口
 */
public interface BeanFactory {

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);

    Object getBean(String name);

}
