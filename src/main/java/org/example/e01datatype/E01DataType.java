package org.example.e01datatype;

public class E01DataType {
    public void execute() {
        boolean bool = true;
        bool = false;
//        bool = 1; 선언할때 데이터 타입과 다를경우 타입에러
        System.out.println(bool);
        System.out.printf("현재 변수 boll값 %s", bool);
        System.out.print(bool);

//        변수 선언
        int age;
        age = 1;
        char ch = 'a';
        String str = "a";

//        상수
        final String USER_NAME = "oo";
//        USER_NAME = "LL";

//        Underscore
        int num = 1_757_450_745;

//        두 변수의 값을 스와핑
        int swap1 = 1;
        int swap2 = 2;
        int swap3;

        swap3 = swap1;
        swap1 = swap2;
        swap2 = swap3;

//      데이터 타입
        boolean bool2 = true;

        byte bt = -13;
        short sh = 32767;
        int integer = 2147483647;
        long longer = 214745373553L; // long은 꼭 마지막 'L'

        double db = 3.141592;
        float ft = 3.141597F; // float은 꼭 마지막 'F'

        char ch1 = 'g';
    }
}
