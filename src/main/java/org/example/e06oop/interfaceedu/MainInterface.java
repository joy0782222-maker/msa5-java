package org.example.e06oop.interfaceedu;

import org.example.e06oop.inheritance.Whale;

public class MainInterface {
    public static void main(String[] args) {
        FlyingFish flyingFish = new FlyingFish();
        System.out.println(flyingFish.flying());

        Whale whale = new Whale();
        System.out.println(whale.residence());
    }
}
