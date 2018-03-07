package com.logic.test;

import com.logic.annotation.Persistent;
import com.logic.annotation.Property;
import com.logic.model.One;
import org.junit.Test;

import java.lang.reflect.Field;

public class AnnotationInfo {

    @Test
    public void annotationInfo() throws ClassNotFoundException {
        // Class personClazz = Class.forName("One");
        Class personClazz = One.class;
        System.out.println(personClazz);
        // Field[] fields = personClazz.getFields();
        Field[] fields = personClazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
            // Annotation[] annotations = field.getAnnotations();
            // Annotation[] annotations = field.getDeclaredAnnotations();
            Property property = field.getAnnotation(Property.class);
            System.out.println(property);
        }
    }

    @Test
    public void simpleAnnotationInfo() throws ClassNotFoundException {
        Class objClazz = Class.forName("One");
        for (Field field : objClazz.getDeclaredFields()) {
            String fieldName = field.getName();
            Property prop = field.getAnnotation(Property.class);
            String column = prop.column();
            String type = prop.type();
            String fieldInfo = String.format("field = %s, column = %s, type = %s", fieldName, column, type);
            System.out.println(fieldInfo);
        }
    }

    @Test
    public void defaultAnnotationInfo() throws ClassNotFoundException {
        Class objClazz = Class.forName("One");
        // Annotation persistent = objClazz.getAnnotation(Persistent.class);
        // TODO: 2017/7/12 多余的强制类型转换
        Persistent persistent = (Persistent) objClazz.getAnnotation(Persistent.class);
        String tableName = "".equals(persistent.table()) ? objClazz.getSimpleName().toLowerCase() : persistent.table();
        System.out.println("tableName = " + tableName);

        for (Field field : objClazz.getDeclaredFields()) {
            String fieldName = field.getName();
            Property prop = field.getAnnotation(Property.class);
            String column = "".equals(prop.column()) ? fieldName : prop.column();
            String type = prop.type();
            String fieldInfo = String.format("field = %s, column = %s, type = %s", fieldName, column, type);
            System.out.println(fieldInfo);
        }
    }
}
