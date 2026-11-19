package org.example.e06oop.inheritance;

public class Whale extends Animal {
    public  Whale(String name, String residence) {
        super(name, residence);
            System.out.println("고래 생성자");

    }

    public Whale() {
        super();
    }

    public String swimming() {
        return String.format("%s가 헤엄칩니다", super.name);
    }

    public boolean residence() {
        return false;
    }


//    필드(Field)
//     public String name = "고래"; // 인스턴스 변수
//    public static int age = 20; // 클래스 변수

//    생성자 메소드
//     Whale() {}

//    메소드(Method)
//     public void swimming() {
//         System.out.println("고래 헤엄");
//     }

}
