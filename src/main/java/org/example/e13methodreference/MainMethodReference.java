package org.example.e13methodreference;

import java.util.Arrays;
import java.util.List;

public class MainMethodReference {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("일", "이", "삼");

        // 람다식
        list.forEach((name) -> System.out.println(name));

        // 메소드
        list.forEach(System.out::println);

    }
}
