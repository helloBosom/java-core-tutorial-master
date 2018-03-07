package com.logic.test;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectInfoTest {
    @Test
    public void methodTest() throws Exception{
        Class clazz = Class.forName("One");
        // Class<?> clazz = Class.forName("One");
        // Class clazz1 = One.class;
        // Class clazz2 = new One().getClass();
        Method infoMethod = clazz.getMethod("info");
        Person person = new Person("zz", 22);
        infoMethod.invoke(person);
        Method infoMethodWithName = clazz.getMethod("info", String.class);
        infoMethodWithName.invoke(person, "newName zz");
        Method infoMethod2 = clazz.getMethod("info", String.class, int.class);
        infoMethod2.invoke(person, "newName zz", 23);

        Person newPerson = (Person) clazz.newInstance();
    }

    @Test
    public void propertiesTest(){
        Properties props = new Properties();
        props.setProperty("name", "zz");
        props.setProperty("age", "123");
        for (Object key : props.keySet()){
            String strKey = (String) key;
            String value = (String) props.get(key);
            System.out.println(strKey + " = " + value);
        }

        for (String key : props.stringPropertyNames())
            System.out.println("key = " + key + ", value = " + props.get(key));

    }

}
