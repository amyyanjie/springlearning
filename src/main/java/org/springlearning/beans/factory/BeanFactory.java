package org.springlearning.beans.factory;

import org.springlearning.beans.BeanDefinition;

public interface BeanFactory {
    BeanDefinition getBeanDefinition(String beanID);

    Object getBean(String beanID);
}
