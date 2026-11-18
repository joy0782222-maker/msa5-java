package org.example.e06oop;

public class AcceseModifier {
    // default 같은패키지에 소속된 클래스에서만 접근
    //  class AcceseModifier
     String strDefault = "Default";

    // public 클래스 내/외부 어디서나 접근가능
    public String strPublic = "Public";

    // private 클래스 내부에서만 접근가능
    private String strPrivate = "private";

    // protected 같은 패키지/ 클래스 내부/ 자식클래스에서 접근가능
    protected String strprotected = "protected";

    void fnDefault() {
        System.out.println("Default Fn");
    }

    public void fnPublic() {
        System.out.println("Public Fn");
    }

    private void fnPrivate() {
        System.out.println("Private Fn");
    }

    protected void fnProtected() {
        System.out.println("Protected Fn");
    }

    public String getStrPrivate() {
        return this.strPrivate;
    }
}
