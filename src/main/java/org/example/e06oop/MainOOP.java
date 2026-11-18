package org.example.e06oop;

public class MainOOP {
    public static void main(String[] args) {
        Whale whale = new Whale();
        Whale whale2 = whale;
        FlyingFish flyingFish = new FlyingFish();
        System.out.println(whale.name);
        whale.swimming();

        whale.name = "돌고래";
        System.out.println(whale.name);

       // System.out.println(Whale.age);
        AcceseModifier acceseModifier = new AcceseModifier();
        acceseModifier.fnProtected();

        // 오버로딩 (Overloading)
        // 메소드의 시그니처가 다르거나 동일한 이름을 가지는 메소드를 중복해 정의
        System.out.println();
        System.out.println(OverloadingOOP.add(1));
        System.out.println(OverloadingOOP.add(1,2));
    }
}
