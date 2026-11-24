package org.example.e12stream;

import org.example.e06oop.inheritance.Whale;

import java.util.ArrayList;
import java.util.List;

public class MainStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(9);

        List<Integer> copyList = new ArrayList<>();
        list.forEach((i) -> {
            copyList.add(i + 3);
        });
        for (int idx = 0; idx < list.size(); idx++) {
            copyList.add(list.get(idx) + 3);
        }
        System.out.println(copyList);

        List<Integer> result1 = list.stream()
            .map((i) -> i + 3)
            .toList();
        System.out.println(result1);

        // 짝수 개수 구하기
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                cnt++;
            }
        }

        long result2 = list.stream()
                .filter((i) -> i % 2 == 0)
                .count();


        List<Whale> whaleList = new ArrayList<>();
        whaleList.add(new Whale("밍크고래", "바다"));
        whaleList.add(new Whale("밍크고래", "바다"));

        whaleList.forEach(item -> {
            System.out.println(item.living());
        });
    }
}
