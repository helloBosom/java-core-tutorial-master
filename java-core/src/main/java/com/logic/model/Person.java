package com.logic.model;

class Person{
    String name;
    int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int hashCode() {
        return age;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj instanceof Person){
            Person p = (Person)obj;

            if(this.name.equals(p.name) &&
                    this.age ==  p.age){
                return true;
            }
        }

        return false;
    }


//    @Override
//    public String toString() {
//        // TODO Auto-generated method stub
//        return this.name + "," + this.age;
//    }



}
