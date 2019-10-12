package com.cf.copyioc.factory;

import com.cf.copyioc.BeanDefinition;
import com.cf.copyioc.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        //初始化bean
        Object beanInstance = createBeanInstance(beanDefinition);
        applyPropertyValues(beanDefinition, beanInstance);
        return beanInstance;
    }

    /**
     * 初始bean的属性
     * @param beanDefinition
     * @param beanInstance
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private void applyPropertyValues(BeanDefinition beanDefinition, Object beanInstance) throws NoSuchFieldException, IllegalAccessException {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field declaredField = beanInstance.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(beanInstance,propertyValue.getValue());
        }
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    private Object createBeanInstance(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
