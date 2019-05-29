package org.springlearning.beans.factory.support;

import org.springlearning.beans.BeanDefinition;

public interface BeanDefinitonRegistry {
    BeanDefinition getBeanDefinition(String beanID);
    void registerBeanDefinition(String beanID, BeanDefinition bd);
}
