package com.example.demo.controller;

import com.example.demo.domain.HotelInfo;
import com.example.demo.domain.accor.HotelDescriptiveContent;
import com.example.demo.utils.OkHttpUtils;
import com.example.demo.utils.XStreamUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class XmlController {

    public static void main(String[] args) throws Exception {
        testXStream();
    }

    /**
     * Xstream xml 转 bean
     * @throws Exception
     */
    public static void testXStream() throws Exception{
        System.out.println("开始           " + LocalDateTime.now());
        String xmlChinese = null;
        HotelInfo hotelInfo = new HotelInfo();
        String originXml = OkHttpUtils.get("https://repos.accor.com/ota/0338.xml");
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = reader.read(new ByteArrayInputStream(originXml.getBytes(StandardCharsets.UTF_8)));
        //3.获取根节点
        Element rootElement = document.getRootElement();
        Element hotelDescriptiveContentsElement = rootElement.element("HotelDescriptiveContents");
        List<Element> hotelDescriptiveContentElementList = hotelDescriptiveContentsElement.elements("HotelDescriptiveContent");
        for(Element hotelDescriptiveContentElement : hotelDescriptiveContentElementList){
            if("zh".equals(hotelDescriptiveContentElement.attributeValue("LanguageCode"))){
                xmlChinese = hotelDescriptiveContentElement.asXML();
                break;
            }
        }
        System.out.println("获取到 xml 片段" + LocalDateTime.now());
        HotelDescriptiveContent hotelDescriptiveContent = XStreamUtils.xmlToBean(xmlChinese, HotelDescriptiveContent.class);
        System.out.println("结束           " + LocalDateTime.now());
        System.out.println(hotelDescriptiveContent);
    }

    /**
     * Dom4j 解析 xml
     * @throws Exception
     */
    public static void testDom4j() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<class>\n" +
                "    <student rollno=\"492\">\n" +
                "        <firstname>cxx1</firstname>\n" +
                "        <lastname>Bob1</lastname>\n" +
                "        <nickname>stars1</nickname>\n" +
                "        <marks>85</marks>\n" +
                "    </student>\n" +
                "    <student rollno=\"493\">\n" +
                "        <firstname>cxx2</firstname>\n" +
                "        <lastname>Bob2</lastname>\n" +
                "        <nickname>stars2</nickname>\n" +
                "        <marks>85</marks>\n" +
                "    </student>\n" +
                "    <student rollno=\"593\">\n" +
                "        <firstname>cxx3</firstname>\n" +
                "        <lastname>Bob3</lastname>\n" +
                "        <nickname>stars3</nickname>\n" +
                "        <marks>85</marks>\n" +
                "    </student>\n" +
                "</class>";
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = reader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        //3.获取根节点
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element stu = (Element) iterator.next();
            List<Attribute> attributes = stu.attributes();
            System.out.println("======获取属性值======");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }
            System.out.println("======遍历子节点======");
            Iterator iterator1 = stu.elementIterator();
            while (iterator1.hasNext()) {
                Element stuChild = (Element) iterator1.next();
                System.out.println("节点名：" + stuChild.getName() + "---节点值：" + stuChild.getStringValue());
            }
        }
    }

}
