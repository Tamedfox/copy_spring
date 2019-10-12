package com.cf.copyioc.beans.factory;


/**
 * beanfactory替换为接口
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
