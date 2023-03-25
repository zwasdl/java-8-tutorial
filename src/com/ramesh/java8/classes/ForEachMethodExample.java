package com.ramesh.java8.classes;

import java.util.ArrayList;
import java.util.List;

public class ForEachMethodExample {
    public static void forEachWithList() {

        final List< Person > items = new ArrayList< >();
        items.add(new Person(100, "Ramesh"));
        items.add(new Person(100, "A"));
        items.add(new Person(100, "B"));
        items.add(new Person(100, "C"));
        items.add(new Person(100, "D"));

        //lambda
        items.forEach(item -> System.out.println(item.getName()));

        //Output : C
        items.forEach(item -> {
            if ("C".equals(item.getName())) {
                System.out.println(item);
            }
        });

        //method reference
        //Output : A,B,C,D,E
        items.forEach(System.out::println);

        //Stream and filter
        //Output : B
        items.stream()
                .filter(s -> s.getName().equals("Ramesh"))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        ForEachMethodExample.forEachWithList();
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public Person(int age, String name) {
        super();
        this.name = name;
        this.age = age;
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

    public String toString() {
        return this.name;
    }
}
