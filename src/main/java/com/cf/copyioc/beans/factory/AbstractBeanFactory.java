package com.cf.copyioc.beans.factory;

import com.cf.copyioc.beans.BeanDefinition;

import java.util.*;

public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
//        Object bean = doCreateBean(beanDefinition);
//        beanDefinition.setBean(bean);
        //懒加载，使用时创建bean
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    @Override
    public Object getBean(String name) throws Exception{
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(beanDefinition == null){
            throw new IllegalArgumentException("No been named" + name + "is defined");
        }

        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void preInstantiateSingletons() throws Exception{
        for(Iterator it = this.beanDefinitionNames.iterator();it.hasNext();){
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    /**
     * 初始化bean
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
