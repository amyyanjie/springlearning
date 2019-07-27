package org.springlearning.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.springlearning.context.ApplicationContext;
import org.springlearning.context.support.ClassPathXmlApplicationContext;
import org.springlearning.service.v1.PetStoreService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContextTest {
    @Test
    public void testGetBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStoreService=(PetStoreService)ctx.getBean("petStore");
        Assert.assertNotNull(petStoreService);
    }
    @Test
    public void test(){
    }


}
