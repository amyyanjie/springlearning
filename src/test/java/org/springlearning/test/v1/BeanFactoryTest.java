package org.springlearning.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.springlearning.beans.BeanDefinition;
import org.springlearning.beans.factory.BeanCreationException;
import org.springlearning.beans.factory.BeanDefinitonStoreException;
import org.springlearning.beans.factory.BeanFactory;
import org.springlearning.beans.factory.support.DefaultBeanFactory;
import org.springlearning.service.v1.PetStoreService;

public class BeanFactoryTest {

    @Test
    public void testGetBean(){
        //目标：给定一个配置文件，去获取bean的定义
        //去获取bean的定义
        //把这个xml传进去。希望这个DefaultBeanFactory能够解析这个xml,能够返回bean的定义
        BeanFactory factory=new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition bd=factory.getBeanDefinition("petStore");
        Assert.assertEquals("org.springlearning.service.v1.PetStoreService",bd.getBeanClassName());
        PetStoreService petStore=(PetStoreService) factory.getBean("petStore");
        Assert.assertNotNull(petStore);

    }

    @Test
    public void testInvalidBean(){
        BeanFactory factory=new DefaultBeanFactory("petstore-v1.xml");
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }
        Assert.fail("expect BeanCreationException");
    }

    @Test
    public void testInvalidXML() {
        try {
            new DefaultBeanFactory("xxxx.xml");
        } catch (BeanDefinitonStoreException e) {
            return;
        }
        Assert.fail("expect BeanDefinitonStoreException");
    }
}
