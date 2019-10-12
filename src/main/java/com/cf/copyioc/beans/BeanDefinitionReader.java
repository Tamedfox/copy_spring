package com.cf.copyioc.beans;

/**
 * 从配置中读取BeanDefinitionReader
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;

}
