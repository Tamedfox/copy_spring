package com.cf.test.xml;

import com.cf.copyioc.beans.BeanDefinition;
import com.cf.copyioc.beans.io.ResourceLoader;
import com.cf.copyioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class XmlBeanDefinitionReaderTest {


    @Test
    public void testXML() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("tinyioc.xml");
        Map<String, BeanDefinition> map = reader.getRegistry();
        Assert.assertTrue(map.size() > 0);
    }

}
