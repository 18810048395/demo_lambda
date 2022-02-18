package com.yh;

import com.yh.entity.Person;
import javafx.util.Builder;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestMethodRef {


    public static void test01(){
        PrintStream ps = System.out;
        Consumer<String> con1 = (s) -> ps.println(s);
        con1.accept("aaa");

        Consumer<String> con2 = ps::println;
        con2.accept("bbb");
    }

    /**
     * 对象引用调用方式
     */
    public static void test02(){
        Person person = new Person();
        person.setName("yanghe");
        Supplier<String> supplier = () -> person.getName();
        String name = supplier.get();
        System.out.println(name);

        Supplier<String> supplier1 = person::getName;
        String name1 = supplier1.get();
        System.out.println(name1);

    }

    /**
     * 静态方法调用方式
     */
    public static void test03(){
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        System.out.println(com1.compare(1, 2));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(2, 1));

    }

    /**
     * 构造器引用
     */
    public static void test04(){
        Supplier<Person> supplier = () -> new Person();
        Person person = supplier.get();
        System.out.println(person);

        Supplier<Person> supplier1 = Person::new;
        Person person1 = supplier1.get();
        System.out.println(person1);

    }

    public static void main(String[] args) {
        List<Integer> stringsList = Arrays.asList(1, 2, 3);
        stringsList.forEach(System.out :: println);
    }
}
