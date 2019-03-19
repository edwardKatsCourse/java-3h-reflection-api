package com.company.intro;

import java.lang.reflect.Field;
import java.util.Set;

@Deprecated
public class Main {

    private static String CONSTANT = "abc";

    public static void main(String[] args) throws Exception {
        IvanCompanyAlarm p = new IvanCompanyAlarm(); // = newInstance()

        createInstance("com.company.intro.IvanCompanyAlarm");

        System.out.println("---------");

        createInstance("com.company.intro.ProductCompany");

        System.out.println("----------");

        createInstance("java.lang.Integer");

        Set<Class> classesWithAnnotation;

    }

    @Deprecated
    private static void createInstance(String classPath) throws Exception {
        Class personClazz = Class.forName(classPath);
        System.out.println("Class name: " + personClazz.getSimpleName());
        //Object myPersonInstance = personClazz.newInstance(); //instance
        //new IvanCompanyAlarm()
        //new ProductCompany()
        //new Integer(int)

        Field [] fields = personClazz.getFields();

        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
        }
    }

    @Override
    public String toString() {
        return "Main{}";
    }
}


class IvanCompanyAlarm {

    public String name;
    public Integer age;

    public IvanCompanyAlarm() {
    }
}

class ProductCompany {
    public String productName;
    public Double declaredPrice;
}