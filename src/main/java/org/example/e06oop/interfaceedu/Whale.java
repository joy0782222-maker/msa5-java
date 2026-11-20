package org.example.e06oop.interfaceedu;

class Whale extends Mammal implements Swim{
    Whale() {
        super("고래", "바다");
    }

    @Override
    public String residence() {
        return String.format("%s가 %s에 삽니다", super.name, super.residence);
    }

    @Override
    public String swimming() {
        return String.format("%s가 %s에 헤엄니다", this.name, this.residence);
    }
}
