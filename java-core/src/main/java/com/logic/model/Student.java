package com.logic.model;

import java.io.*;

/**
 * 自定义类Student
 */
public class Student implements Cloneable, Serializable {
    String name;
    public int age;
    public School school;

    public Student() {
    }

    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    /**
     * @return 克隆出的对象
     * @throws CloneNotSupportedException，如果当前类没有实现Cloneable类，则抛出该异常
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 自定义的方法，通过序列化实现深克隆
     *
     * @return
     */
    public Object deepClone() {
        // if (src == null) return null;
        Object src = this;
        Object obj = null;
        try {
            // 序列化
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(src);  // 将该对象序列化到 baos 中

            // 反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            obj = ois.readObject();

            // 应该在finally 代码块中关闭资源
            ois.close();
            bais.close();
            oos.close();
            baos.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
