package org.springlearning.beans.factory.support;


import org.springlearning.beans.BeanDefinition;
import org.springlearning.beans.factory.BeanCreationException;
import org.springlearning.beans.factory.BeanFactory;
import org.springlearning.beans.factory.config.ConfigurableBeanFactory;
import org.springlearning.util.ClassUtils;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SRP:单一职责原则
 * 对一个类而言，应该仅有一个引起它变化的原因
 */
public class DefaultBeanFactory implements ConfigurableBeanFactory, BeanDefinitonRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);
    private ClassLoader beanClassLoader;

    public DefaultBeanFactory() {

    }

    public BeanDefinition getBeanDefinition(String beanID) {
        return this.beanDefinitionMap.get(beanID);
    }

    public void registerBeanDefinition(String beanID, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanID, bd);
    }

    //取的时候，把他通过反射的方式把类装载进来，再newInstance
    public Object getBean(String beanID) {
        BeanDefinition bd = this.getBeanDefinition(beanID);
        if (bd == null) {
            throw new BeanCreationException("Bean Definition doesn't exit");
        }
        ClassLoader cl = this.getBeanClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for " + beanClassName + "+failed", e);
        }
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader = beanClassLoader != null ? beanClassLoader : ClassUtils.getDefaultClassLoader();
    }
}
