package me.whiteship.designpatterns._03_behavioral_patterns._15_interpreter._02_after;

import java.util.Map;

public class App {

    public static void main(String[] args) {

        //실제 숫자가 아니라 문자로 x,y,z로 일단 표헌식을 주고
        PostfixExpression expression = PostfixParser.parse("xyz+-a+");

        //expression.interpret() 이용해서 x,y,z 대신 숫자를 넣어주는 것임
        int result = expression.interpret(Map.of('x', 1, 'y', 2, 'z', 3, 'a', 4));

        System.out.println(result);
    }
}














