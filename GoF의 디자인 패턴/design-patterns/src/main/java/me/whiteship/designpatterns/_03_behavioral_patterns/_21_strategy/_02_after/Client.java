package me.whiteship.designpatterns._03_behavioral_patterns._21_strategy._02_after;

import java.util.Collections;
import java.util.Comparator;

public class Client {

    public static void main(String[] args) {
        BlueLightRedLight game = new BlueLightRedLight();
        //여기서 전략 선택
        game.blueLight(new Normal());
        game.redLight(new Fastest());
        game.blueLight(new Speed() {//원하는 전략을 이렇게 수정해서 넣어줄수도 있음
            @Override
            public void blueLight() {
                System.out.println("blue light");
            }

            @Override
            public void redLight() {
                System.out.println("red light");
            }
        });
    }
}
