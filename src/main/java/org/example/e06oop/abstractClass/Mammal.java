package org.example.e06oop.abstractClass;

public abstract class Mammal {
    protected String name;
    protected String residence;

    public String brreath() {
        return String.format("%s가 숨을 쉼", this.name);

    }

    // 추상 메소드 : 상속 관계에서 자식 클래스에게 특정 기능을 반드시 구현하도록 강제
    public abstract String living();

}
