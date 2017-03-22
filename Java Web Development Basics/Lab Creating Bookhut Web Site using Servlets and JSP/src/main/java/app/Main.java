package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Galin on 19.2.2017 г..
 */
public class Main {
    private static List<Person> persons=new ArrayList<>();

    public static void main(String[] args) {
        Person p1=new Person("Pesho",12);
        Person p2=new Person("Gosho",14);

        persons.add(p1);
        persons.add(p2);

        p1.setName("Piqn Solo");

        Person person=persons.stream().filter(p->p.getName().equals("Pesho")).findFirst().orElse(null);

        System.out.println();
    }
}

class Person {
    private String name;

    private int age;

    public Person(){
    }

    public Person(String name,int age){
        this();
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
