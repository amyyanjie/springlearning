package org.springlearning.beans.factory.config;

import org.springlearning.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {
    void setBeanClassLoader(ClassLoader beanClassLoader);

    ClassLoader getBeanClassLoader();
}
