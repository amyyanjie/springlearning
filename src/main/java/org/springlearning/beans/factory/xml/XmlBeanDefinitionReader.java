package org.springlearning.beans.factory.xml;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springlearning.beans.BeanDefinition;
import org.springlearning.beans.factory.BeanDefinitonStoreException;
import org.springlearning.beans.factory.support.BeanDefinitonRegistry;
import org.springlearning.beans.factory.support.GenericBeanDefinition;
import org.springlearning.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class XmlBeanDefinitionReader {
    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";
    private BeanDefinitonRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitonRegistry registry) {
        this.registry=registry;
    }

    public void loanBeanDefinitions(String configFile) {
        InputStream is = null;
        try {
            ClassLoader cl = ClassUtils.getDefaultClassLoader();
            is = cl.getResourceAsStream(configFile);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);  //xml称为Document

            Element root = doc.getRootElement();  //</beans>
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                this.registry.registerBeanDefinition(id, bd);
            }
        } catch (DocumentException e) {
            throw new BeanDefinitonStoreException("IOException parsing XML document failed ");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
