package com.logic.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    @Test
    public void test() {
        List<String>[] lists = new List[10];
        for (int i = 0; i < 10; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                list.add("" + i + "-" + j);
            }
            lists[i] = list;
        }

        for (List<String> list : lists)
            System.out.println(list);
    }
}
