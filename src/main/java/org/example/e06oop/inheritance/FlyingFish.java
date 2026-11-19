package org.example.e06oop.inheritance;

public class FlyingFish extends Animal {
    public  FlyingFish(String name, String residence) {
        super(name, residence);
        System.out.println("날치 생성자");
    }

    public String flying() {
        return String.format("%s가 날아갑니다", super.name);
    }

    // 오버라이딩(Overriding) 부모에게 상속받은 메소드를 자식이 재정의해 사용
    // @ 어노테이션(Annotation) 은 자바에서 코드에 추가 정보를 표시하는 기능
    @Override
    public String living() {
        return "수정";
    }

}
