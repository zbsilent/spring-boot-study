package com.srpingstudy.jdks;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest

class SpringBootStudyJdksApplicationTests {

    @Test
    void contextLoads() {
    }

    public void constructionStreamFun(){
        String[] strArray = new String[] { "a", "b", "c" };
        List<String> list = Arrays.asList(strArray);

        /* 本质上是调用了Arrays.stream(strArray) 这里的strArray传入的其实就是一个可变参数列表*/
        Stream<String> stream = Stream.of("a", "b", "c");
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        stream = list.stream();
        System.out.println(stream);
    }

    @Test
    public void Jdks8Test() {
        List<String> names = new ArrayList<>();
        names.add("jaxe2323");
        names.add("Taxe2323");
        names.add("jaxU");
        /* * 更像是一种条件表达式，返回一个Predicate*/
        Predicate<String> startWithJ = (n) -> n.startsWith("j");
        Predicate<String> retLenExceedFour = (n) -> n.length() == 4;
        names.stream().filter(startWithJ.and(retLenExceedFour)).forEach(System.out::println);


        List<String> collect = names.stream().map(String::toLowerCase).collect(Collectors.toList());
    }
}
