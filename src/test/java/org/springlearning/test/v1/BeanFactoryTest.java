package org.springlearning.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springlearning.beans.BeanDefinition;
import org.springlearning.beans.factory.BeanCreationException;
import org.springlearning.beans.factory.BeanDefinitonStoreException;
import org.springlearning.beans.factory.support.DefaultBeanFactory;
import org.springlearning.beans.factory.xml.XmlBeanDefinitionReader;
import org.springlearning.service.v1.PetStoreService;

public class BeanFactoryTest {
    private DefaultBeanFactory factory;
    private XmlBeanDefinitionReader reader;

    //运行每个测试用例时，都会执行setUp()，每个测试用例中factory,reader都是最新的，互不影响。
    @Before
    public void setUp() {
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }

    @Test
    public void testGetBean() {
        //目标：给定一个配置文件，去获取bean的定义
        //去获取bean的定义
        //把这个xml传进去。希望这个DefaultBeanFactory能够解析这个xml,能够返回bean的定义
//        BeanFactory factory=new DefaultBeanFactory("petstore-v1.xml");

        reader.loanBeanDefinitions("petstore-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");
        Assert.assertEquals("org.springlearning.service.v1.PetStoreService", bd.getBeanClassName());
        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");
        Assert.assertNotNull(petStore);
    }

    @Test
    public void testInvalidBean() {
        reader.loanBeanDefinitions("petstore-v1.xml");
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
            reader.loanBeanDefinitions("xxx.xml");
        } catch (BeanDefinitonStoreException e) {
            return;
        }
        Assert.fail("expect BeanDefinitonStoreException");
    }
}
