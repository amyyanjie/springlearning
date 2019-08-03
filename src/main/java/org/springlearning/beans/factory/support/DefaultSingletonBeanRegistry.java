package org.springlearning.beans.factory.support;

import org.springlearning.beans.factory.config.SingletonBeanRegistry;
import org.springlearning.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    public final Map<String, Object> singletonObject = new ConcurrentHashMap<String, Object>(64);

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        Assert.notNull(beanName, "'beanName' must not be null");
        Object oldObject = this.singletonObject.get(beanName);
        if (oldObject != null) {
            throw new IllegalStateException("Could not register object [" + singletonObject +
                    "] under bean name '" + beanName + "': there is already object [" + oldObject + "] bound");
        }
        this.singletonObject.put(beanName, singletonObject);

    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObject.get(beanName);
    }
}
