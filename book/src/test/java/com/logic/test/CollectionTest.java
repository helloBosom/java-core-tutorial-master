package com.logic.test;

import com.logic.model.One;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;

public class CollectionTest {

    @Test
    public void setTest() {
        HashSet<One> hashSet = new HashSet<>();

        // 测试，hashCode不一样，equals相等，是否能添加成功
        // 结果为，能添加成功
        One p1 = new One(1, "name1");
        One p2 = new One(2, "name1");
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet.size());  // 2
        hashSet.remove(p1);
        System.out.println(hashSet.contains(p1));  // false
        // HashMap
        // 测试，hashCode一样
    }

    @Test
    public void comparatorTest() {
        Comparator<One> cmp = new Comparator<One>() {
            @Override
            public int compare(One o1, One o2) {
                return o1.age - o2.age;
            }
        };
    }
}
