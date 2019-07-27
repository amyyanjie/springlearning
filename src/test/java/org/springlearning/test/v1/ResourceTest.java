package org.springlearning.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.springlearning.core.io.ClassPathResource;
import org.springlearning.core.io.FileSystemResource;
import org.springlearning.core.io.Resource;

import java.io.InputStream;

public class ResourceTest {
    @Test
    public void testClassPathResource() throws Exception{
        Resource r=new ClassPathResource("petStore-v1.xml");
        InputStream is=null;
        try {
            is=r.getInputStream();
            Assert.assertNotNull(is);
        } finally {
            if (is!=null){
                is.close();
            }

        }
    }

    @Test
    public void testFileSystemResource() throws Exception{
        Resource r= new FileSystemResource("/Users/yanjie/Public/learn/springlearning/src/test/resources/petstore-v1.xml");
        InputStream is=null;
        try {
            is=r.getInputStream();
            Assert.assertNotNull(is);
        } finally {
            if (is!=null){
                is.close();
            }

        }

    }
}
