package com.logic.test;

import com.logic.model.School;
import com.logic.model.Student;
import org.junit.Test;

import java.io.*;

public class ShadowDeepClone {
    School school = new School("育才小学");
    Student student = new Student("小明", 10, school);

    @Test
    public void shadowClone() throws CloneNotSupportedException {
        // 克隆对象
        Student studentCopy = (Student)student.clone();

        // 验证两个对象是不是同一个对象
        System.out.println("student == studentCopy ? " + (student == studentCopy));
        // 原始类型（基本类型）的变量的值是一样的。
        System.out.println("student.age == studentCopy.age ? " + (student.age == studentCopy.age));
        // System.out.println("student == studentCopy ? " + (student.name == studentCopy.name));
        // 引用类型的成员变量的值是一样的，也就是引用同一个对象
        System.out.println("student.school == studentCopy.school ? " + (student.school == studentCopy.school));
    }

    @Test
    public void deepClone(){
        Student studentCopy = (Student) student.deepClone();
        // 验证两个对象是不是同一个对象
        System.out.println("student == studentCopy ? " + (student == studentCopy));
        // 原始类型（基本类型）的变量的值是一样的。
        System.out.println("student.age == studentCopy.age ? " + (student.age == studentCopy.age));
        // System.out.println("student == studentCopy ? " + (student.name == studentCopy.name));
        // 引用类型的成员变量的值是一样的，也就是引用同一个对象
        System.out.println("student.school == studentCopy.school ? " + (student.school == studentCopy.school));
    }
}
