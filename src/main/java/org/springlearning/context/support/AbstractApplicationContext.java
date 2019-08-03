package org.springlearning.context.support;

import org.springlearning.beans.factory.support.DefaultBeanFactory;
import org.springlearning.beans.factory.xml.XmlBeanDefinitionReader;
import org.springlearning.context.ApplicationContext;
import org.springlearning.core.io.Resource;
import org.springlearning.util.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory=null;
    private ClassLoader beanClassLoader;

    public AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = getResourceByPath(configFile);
        reader.loanBeanDefinitions(resource);
        factory.setBeanClassLoader(this.getBeanClassLoader());
    }

    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }

    protected  abstract Resource getResourceByPath(String path);

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader = beanClassLoader != null ? beanClassLoader : ClassUtils.getDefaultClassLoader();
    }
}
