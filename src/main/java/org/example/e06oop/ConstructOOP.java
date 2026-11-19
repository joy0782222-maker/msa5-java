package org.example.e06oop;

public class ConstructOOP {
    private String name;
    private int age;
    private char gender;

    // 생성자 (Constructor) 메소드
    // 클래스를 인스턴스화 할때 최소 1회만 실행
    // 객체 초기화, 인스턴스 생성시 실행되어야할 작업을 위해 사용

    // 기본 생성자 : 개발자가 생성자를 별도로 정의하지 않으먄 자동으로 생성
    public ConstructOOP() {
        this("무명", 20, 'M');
    }

    // 커스텀 생성자
    public ConstructOOP(String name) {
        // this(); // 기본생성자 호출이 생략되어 있다.
        // this 참조 변수: 클래스 자기 자신을 가리킴
        this(name, 20);
    }

    public ConstructOOP(String name, int age) {
        this(name, age, 'M');
    }

    public ConstructOOP(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}