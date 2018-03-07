package fun.peri.model;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-12 12:39
 */

class Person{
    private int age;
    public Person(){}
    public Person(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
