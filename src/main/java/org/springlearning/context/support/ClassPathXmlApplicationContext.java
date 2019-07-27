package org.springlearning.context.support;

import org.springlearning.beans.factory.support.DefaultBeanFactory;
import org.springlearning.beans.factory.xml.XmlBeanDefinitionReader;
import org.springlearning.context.ApplicationContext;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    public DefaultBeanFactory factory;

    public ClassPathXmlApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loanBeanDefinitions(configFile);
    }

    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }
}
