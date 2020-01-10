package com.six.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanFactory {

    //存放xml里的
    Map map = new HashMap<String, Object>();

    /**
     * @param xml 存放类信息的文件
     */
    public BeanFactory(String xml) {
        parseXml(xml);
    }

    /**
     * @param beanName 传入需要的beanName
     * @return
     */
    public Object getBean(String beanName) {
        return map.get(beanName);
    }


    /**
     * 解析xml文件
     *
     * @https://dom4j.github.io/ dom4j文档
     */

    public void parseXml(String xml) {
        //读取xml文件
        File xmlPaht = new File(this.getClass().getResource("/").getPath() + "//" + xml);
        System.out.println(xmlPaht);
        SAXReader reader = new SAXReader();
        try {
            //document就是整个xml文件
            Document document = reader.read(xmlPaht);

            //获取根节点（beans）,能不能有多个根节点
            Element beansElement = document.getRootElement();
            System.out.println(beansElement.getName());

            //获取根节点下的子节点（bean）等
            //实例化bean对象，存到map
            Object object = null;
            for (Iterator<Element> it = beansElement.elementIterator(); it.hasNext(); ) {
                Element element = it.next();
                //现在获取到的是<bean id="userService" class="com.zbk.dao...">,存放到map中
                System.out.println("element----------" + element);

                //获取到bean标签的id属性
                Attribute labelId = element.attribute("id");
                System.out.println("labelId" + labelId);
                //获取到id对应的值
                String idValue = labelId.getValue();
                System.out.println("idValue-----------" + idValue);
                //获取到bean标签的class属性
                Attribute labelClass = element.attribute("class");
                System.out.println("labelClass--------" + labelClass);
                String classValue = labelClass.getValue();
                System.out.println("classValue---------" + classValue);
                //有了类名可以实例化类信息
                Class clazz = Class.forName(classValue);
//                object = clazz.newInstance();
                /**
                 * 添加依赖关系
                 * 看这个对象有没有依赖（property）或者判断类是否有属性
                 * 继续判断这个标签是否有子标签？property标签或者constructor
                 */
                for (Iterator<Element> itSecond = element.elementIterator(); itSecond.hasNext(); ) {
                    //第二层子标签<property>

                    Element elementSecond = itSecond.next();
                    if (elementSecond.getName().equals("property")) {
                        //因为是setter方法注入，不需要特殊的构造方法，直接new对象
                        object = clazz.newInstance();
                        //得到的是ref对应的value，也就是指向的依赖的对象<property name="userService" ref="userService" >
                        String refValue = elementSecond.attribute("ref").getValue();
                        //通过key去map里找,,
                        Object injectObject = map.get(refValue);
                        System.out.println("依赖的对象" + injectObject);
                        //当前类的属性名字
                        String nameValue = elementSecond.attribute("name").getValue();
                        System.out.println("当前类的属性" + nameValue);
                        Field thisClassFieldName = clazz.getDeclaredField(nameValue);
                        thisClassFieldName.setAccessible(true);
                        thisClassFieldName.set(object, injectObject);
                    } else if (elementSecond.getName().equals("constructor-arg")) {
                        //证明有构造方法
                        String refValue = elementSecond.attribute("ref").getValue();
                        Object injectObject = map.get(refValue);
                        //获取构造方法的参数类型
                        Class constutorClassType = injectObject.getClass().getInterfaces()[0];
                        //当前类的构造方法
                        Constructor constructor = clazz.getConstructor(constutorClassType);
                        //构造方法new对象,传入ref的对象
                        object = constructor.newInstance(injectObject);

                    }

                }

                if (null == object) {
                    object = clazz.newInstance();
                }
                map.put(idValue, object);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);

    }
}
