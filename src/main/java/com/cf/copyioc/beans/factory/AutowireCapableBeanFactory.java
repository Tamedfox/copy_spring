package com.cf.copyioc.beans.factory;

import com.cf.copyioc.beans.BeanDefinition;
import com.cf.copyioc.BeanReference;
import com.cf.copyioc.beans.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        //初始化bean
        Object beanInstance = createBeanInstance(beanDefinition);
        beanDefinition.setBean(beanInstance);
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
    private void applyPropertyValues(BeanDefinition beanDefinition, Object beanInstance) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field declaredField = beanInstance.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
//            declaredField.set(beanInstance,propertyValue.getValue());
            Object value = propertyValue.getValue();
            if(value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;
                value= getBean(beanReference.getName());
            }
            declaredField.set(beanInstance,value);
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
