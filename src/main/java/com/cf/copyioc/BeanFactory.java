package com.cf.copyioc;

import java.util.HashMap;
import java.util.Map;

/**
 *bean的容器
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public void registerBeanDefination(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

}
