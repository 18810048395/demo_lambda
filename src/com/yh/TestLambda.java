package com.yh;

import com.yh.entity.Person;
import com.yh.service.MyFunction;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda {

    /**
     * 使用lambda表达式，测试Collections.sort内部实现Comparable接口
     */
    public static void test1(){
        List<Person> people = Arrays.asList(
                new Person(2, "yh2", 10),
                new Person(3, "yh3", 12),
                new Person(5, "yh5", 11),
                new Person(1, "yh1", 11),
                new Person(4, "yh4", 13)
        );

        Collections.sort(people,(p1,p2)-> {
            // 按照年龄从大到小排序，如果年龄一样，按照id从小到大排序
            if(p1.getAge() == p2.getAge()){
                return Integer.compare(p1.getId(),p2.getId());
            }else{
                return -Double.compare(p1.getAge(),p2.getAge());
            }
        });

        for (Person p:people) {
            System.out.println(p);
        }
    }

    /**
     * 自定义Lambda接口
     */
    public static void test2( ){
        String name = "YangHe";
        MyFunction myFunction1 = ((str) -> str.toUpperCase());
        System.out.println(myFunction1.getValue(name));

        MyFunction myFunction2 = ((str) -> str.toLowerCase());
        System.out.println(myFunction2.getValue(name));

    }

    /**
     * jdk8内置接口(消费型接口)
     */
    public static void test3(){
        //Consumer
        Consumer<Integer> consumer = (x) -> System.out.println("消费型接口" + x);
        //test
        consumer.accept(100);
    }

    /**
     * jdk8内置接口(提供型接口)
     */
    public static void test4(){
        List<Integer> list = new ArrayList<>();
        List<Integer> integers = Arrays.asList(1,2,3);
        list.addAll(integers);
        //Supplier<T>
        Supplier<Integer> supplier = () -> (int)(Math.random() * 10);
        list.add(supplier.get());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * jdk8内置接口(函数型接口)
     */
    public static void test5(){
        //Function<T, R>
        String oldStr = "abc123456xyz";
        Function<String, String> function = (s) -> s.substring(1, s.length()-1);
        //test
        System.out.println(function.apply(oldStr));
    }

    /**
     * jdk8内置接口(判断型接口)
     */
    public static void test6(){
        //Predicate<T>
        Integer age = 35;
        Predicate<Integer> predicate = (i) -> i >= 35;
        if (predicate.test(age)){
            System.out.println("你该退休了");
        } else {
            System.out.println("我觉得还OK啦");
        }
    }

    public static void main(String[] args) {
        test6();
    }


}
