package com.logic.test;

import com.logic.model.Person;

import java.util.HashSet;

public class SetDemo {

    public static void main(String[] args) {
        HashSet<Person> personSet = new HashSet<Person>();

        Person p1 = new Person("zhangsan",13);
        Person p2 = new Person("zhangsan",12);

        personSet.add(p1);
        personSet.add(p2);

        for (Person person : personSet) {
            System.out.println(person.toString());
        }

        System.out.println();

        // p1.name = "zhangsan";
        p1.age = 15;
        System.out.println("contains(p1) = " + personSet.contains(p1));

        for (Person person : personSet) {
            System.out.println(person.toString());
        }
        //personSet.add(p1);

        System.out.println(personSet.size());

        System.out.println(String.format("personSet.contains(p1), ", personSet.contains(p1)));
        System.out.println(String.format("personSet.contains(p2), ", personSet.contains(p2)));
        System.out.println("address of p1 = " + p1);
        // System.out.println("address of p1 = " + p1.toString());

        System.out.println("identityHashCode(p1) = " + System.identityHashCode(p1));
        System.out.println("identityHashCode(p1) = " + System.identityHashCode(p2));
        // classname@hashcode
        System.out.println("address of p2 = " + p2);
        System.out.println();
        System.out.println(String.format("p1.equals(p2) = %s", p1.equals(p2)));
        System.out.println(String.format("p1 == p2 , %s ", p1 == p2));

        // personSet.remove(p1);
        System.out.println(personSet.size());




    }


}
