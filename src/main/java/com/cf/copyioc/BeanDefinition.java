package com.cf.copyioc;

/**
 * 封装bean对象，保存bean的额外信息
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean(){
        return bean;
    }
}
