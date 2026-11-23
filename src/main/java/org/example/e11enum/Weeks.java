package org.example.e11enum;
public enum Weeks {
    // Enum : 상수의 집합을 편리하게 선언하고 사용하기 위함
    // private Weeks MONDAY = new Weeks();
    MONDAY("월", 1),
    WEDNESDAY("수", 2),
    TUESDAY("화", 3),
    THURSDAY("목",4),
    FRIDAY("금",5),
    SATURDAY("토",6),
    SUNDAY("일",0);

    private final String krDay;
    private final int dayNum;

    Weeks(String krDay, int dayNum) {
        this.krDay = krDay;
        this.dayNum = dayNum;
    }

    // Getter
    public String getKrDay() {
        return this.krDay;
    }

    public int getDayNum() {
        return dayNum;
    }
}

// public class Weeks {
    // public static final String MONDAY = "월";
    // public final static String MONDAY = "월";
    // public final static String TUESDAY = "화";
    //
    // public static String convertKrToEn(String day) {
    //     switch (day) {
    //         case Weeks.MONDAY:
    //             return "MONDAY";
    //         case Weeks.TUESDAY:
    //             return "TUESDAY";
    //         default:
    //             return "";
    //     }
    // }

    // private final String day;
    // public Weeks(String day) {
    //     this.day = day;
    // }
    // public String getDay() {
    //     return this.day;
    // }
// }

