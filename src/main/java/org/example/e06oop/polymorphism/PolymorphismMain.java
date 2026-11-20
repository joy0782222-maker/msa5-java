package org.example.e06oop.polymorphism;

public class PolymorphismMain {
    public static void main(String[] args) {
        Whale whale1 = new Whale();
        Mammal whale2 = new Whale();

        Monkey monkey1 = new Monkey();
        Mammal monkey2 = new Monkey();

        Saba saba1 = new Saba();
        // Mammal saba2 = new Saba();


        Mammal[] arr = new Mammal[5];
        arr[0] = new Whale();
        arr[1] = new Monkey();
        arr[2] = new Mammal();


        // 업캐스팅 : 자식 클래스가 부모 클래스 타입으로 캐스팅 됨
        // 부모 클래스로 캐스팅 되면 자식클래스 멤버에는 접근불가
        Mammal upCasting1 = new Whale();
        // upCasting1.swimming(); //자식클래스 swimming() 접근 안됨

        // 다운캐스팅 : 업캐스팅한 인스턴스를 다시 본인의 데이터 타입으로 캐스팅
        Whale downCasting1 = (Whale) upCasting1;
        downCasting1.swimming();


        Mammal mammal = new Mammal();
        Whale whale3 = (Whale) mammal;
    }
}
