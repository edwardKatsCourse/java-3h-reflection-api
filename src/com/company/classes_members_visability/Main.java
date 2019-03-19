package com.company.classes_members_visability;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        //Declared:
        //1. show all (private/protected)
        //2. shows the current class (without parents)

        Class childClazz = Class.forName("com.company.classes_members_visability.ExampleChild");

        System.out.println("Constructors - public");
        Arrays.stream(childClazz.getConstructors())
                .forEach(constructor -> System.out.println(constructor.toString()));

        System.out.println();

        System.out.println("Constructors - all"); //D.E.C.L.A.R.E.D CONSTRUCTORS
        Arrays.stream(childClazz.getDeclaredConstructors())
                .forEach(constructor -> System.out.println(constructor.toString()));

        System.out.println();

        System.out.println("Fields - public");
        Arrays.stream(childClazz.getFields())
                .forEach(field -> System.out.println(field.toString()));

        System.out.println();
        System.out.println("Fields - all");
        Arrays.stream(childClazz.getDeclaredFields())
                .forEach(field -> System.out.println(
                        String.format("Modifier: %s | Field type: %s | Field name: %s",
                                Modifier.toString(field.getModifiers()),
                                field.getType().getSimpleName(),
                                field.getName())
                ));

        System.out.println();
        System.out.println("Methods - public");
        Arrays.stream(childClazz.getMethods())
                .forEach(method -> System.out.println(method.toGenericString()));


        System.out.println();
        System.out.println("Methods - all (any modifier, without parent)");
        Arrays.stream(childClazz.getSuperclass().getDeclaredMethods())
                .forEach(method -> System.out.println(method.toString()));

        System.out.println();

        //ExampleChild -> Example
        Class parentClass = childClazz.getSuperclass();
        System.out.println("Super Fields - All");
        Arrays.stream(parentClass.getDeclaredFields())
                .forEach(field -> System.out.println(field.toString()));

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Old way instance creation (default ctor)");
        new Example();

        System.out.println("--------");
        System.out.println("Reflection way instance creation (default ctor)");

        childClazz.newInstance(); //new Example()

        //new Example() = .newInstance()




    }
}


class Example {

    private String name;
    protected Integer abc;
    public StringBuilder sb;
    StringBuilder sbDefault;

    public Example() {
        System.out.println("I am default constructor");
    }

    protected Example(int i) {}
    Example(int i, int y) {}
    private Example(int i, String s) {}


    private void myMethod() {}
    protected void myMethod(Integer i) {}
    void myMethod(Integer i, String s) {}
    public void myMethod(Double arg0, Short arg1) {}
}

class ExampleChild extends Example {
}