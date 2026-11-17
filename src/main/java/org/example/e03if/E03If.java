package org.example.e03if;

public class E03If {
    public static void main(String[] args) {
        int score = 0;
        String str = null;
//        if (score < 0 || score > 100){
//            System.out.println("유효한 점수가 아닙니다");
//        } else
        if (score >= 0 && score <= 100) {
            if (score == 100){
                str = "A+";
            } else if (score >= 90) {
                str = "A";
            } else if (score >= 80) {
                str = "B";
            } else if (score >= 70) {
                str = "C";
            } else if (score >= 60) {
                str = "D";
            } else if (score < 60) {
                str = "F";
            }
            System.out.println("당신의 점수는 "+str+"입니다");
    //        System.out.printf("**u score %d. <%s>**", score, str);

        } else {
            System.out.println("유효한 점수가 아닙니다");
        }

//        switch
        int num = 1;

        switch(num) {
            case 1:
                System.out.println("1등");
                break;
            case 2:
                System.out.println("2등");
                break;
            case 3:
                System.out.println("3등");
            default:
                System.out.println("등수 외");
                break;
        }
}}

//0~100 의 숫자가 아닐경우 오동작함
//유효한 숫자가 아닙니다 출력
//그 외 패턴은 기존과 동일