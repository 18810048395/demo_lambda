package com.yh;

import com.yh.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 */
public class TestStream {

    public static List<Person> people = Arrays.asList(
            new Person(2, "yh2", 10),
            new Person(3, "yh3", 12),
            new Person(5, "yh5", 11),
            new Person(1, "yh1", 11),
            new Person(4, "yh4", 13)
    );

    public static void main(String[] args) {
        test02();
    }

    public static void test01(){

        List<Person> personList = people.stream()
                .filter((person -> person.getAge() >= 10)) //年龄大于等于10
                .map((person -> { // 新增一个函数，并应用到每一个元素中，映射成新的元素
                    person.setName(person.getName().toUpperCase());
                    return person;
                }))
                .limit(3) //就取三个
                .skip(1)  // 查询结果后，跳过一个元素
                .collect(Collectors.toList()); //终止操作，将流整理成一个集合

        System.out.println(personList);
    }

    public static void test02(){
        Map<Integer, List<Person>> collect = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(collect);
    }

    public static void test03(){
        List<String> list = Arrays.asList("yanghe", "xiaohei", "xiaobai");
        list.stream()
                .flatMap(TestStream::filterCharacter)
                .forEach(System.out::println);
    }
    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }



}
