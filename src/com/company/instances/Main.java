package com.company.instances;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

//        Class clazz = Person.class;
        Class personBlueprint = Class.forName("com.company.instances.Person");

//        Person person = new Person();
        Object peter = personBlueprint.newInstance();
        Object natasha = personBlueprint.newInstance();


        //person.printTest() -> compilation error (private method)
        Method printTestMethod = personBlueprint.getDeclaredMethod("printTest");
        printTestMethod.setAccessible(true); //confirmation to work with PRIVATEs
        printTestMethod.invoke(peter);


        Field nameField = personBlueprint.getDeclaredField("name");
        Field ageField = personBlueprint.getDeclaredField("age");

        System.out.println("Name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Age: ");
        Integer age = new Scanner(System.in).nextInt();

        //person.name = "peter"
        nameField.setAccessible(true);
        nameField.set(peter, name);

        //person.age = 41
        ageField.setAccessible(true);
        ageField.set(peter, age);


        //peter.print()
        Method print = personBlueprint.getDeclaredMethod("print", String.class); //print(String)
        print.invoke(peter, "abc"); //print("abc")

        //Method = name + params

        //natasha.name = "Natalie"
        nameField.set(natasha, "Natalie");

        //natasha.age = 26
        ageField.set(natasha, 26);

        //person.print("nata");
        print.invoke(natasha, "nata");
    }
}

class Person {

    private String name;
    private Integer age;

    public Person() {
        System.out.println("person ctor");
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void print(String s) {

        System.out.println(String.format("Method param: %s | %s", s, this.toString()));
    }

    private void printTest() {
        System.out.println("printed via reflection");
    }


    @Override
    public String toString() {
        return String.format("Name: %s | Age: %s",
                this.name,
                this.age);
    }
}
