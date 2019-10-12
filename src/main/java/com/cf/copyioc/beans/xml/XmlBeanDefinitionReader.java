package com.cf.copyioc.beans.xml;

import com.cf.copyioc.beans.AbstractBeanDefinitionReader;
import com.cf.copyioc.beans.BeanDefinition;
import com.cf.copyioc.BeanReference;
import com.cf.copyioc.beans.PropertyValue;
import com.cf.copyioc.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        //解析bean
        registerBeanDefinitions(doc);
        inputStream.close();
    }

    private void registerBeanDefinitions(Document doc) {
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);

    }

    private void parseBeanDefinitions(Element root) {
        //解析root
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;

                //定义bean
                processBeanDefinition(ele);

            }
        }
    }

    private void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        //设置属性
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name,beanDefinition);
    }

    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for(int j = 0; j< propertyNode.getLength(); j++){
            Node item = propertyNode.item(j);
            if(item instanceof Element){
                Element propertyEle = (Element) item;
                String attrName = propertyEle.getAttribute("name");
                String attrValue = propertyEle.getAttribute("value");
                //是value值则添加value属性
                if(attrValue != null && attrValue.length() > 0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(attrName,attrValue));
                }else{
                    //ref属性
                    String ref = propertyEle.getAttribute("ref");
                    if(ref == null || ref.length() == 0){
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + attrName + "' must specify a ref or value");
                    }

                    //将属性引用加入beanDefinition的propertyValues中
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(attrName,beanReference));
                }
            }
        }
    }
}
