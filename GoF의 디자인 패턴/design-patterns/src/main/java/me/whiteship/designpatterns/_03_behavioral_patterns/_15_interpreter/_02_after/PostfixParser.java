package me.whiteship.designpatterns._03_behavioral_patterns._15_interpreter._02_after;

import java.util.Stack;

import static me.whiteship.designpatterns._03_behavioral_patterns._15_interpreter._02_after.PostfixExpression.*;

public class PostfixParser {

    public static PostfixExpression parse(String expression) {

        Stack<PostfixExpression> stack = new Stack<>();

        //여기서 for 문을 반복하면서 연산하고 stack에 다시 넣고를 반본하변서 연산함
        for (char c : expression.toCharArray()) {
            //여기서 보면 push 만 하는 것 처럼 보이지만 getExpression()으로 들어가보면, pop 을 함
            stack.push(getExpression(c, stack));
        }
        // 여기서 Stack<PostfixExpression> 스택에는 PlusExpression, MinusExpression, VariableExpression 가 있는 것임
        // "xyz+-a+"
        // => y+z , x-(y+z), "x-(y+z)" + a
        // = c PlusExpression, c MinusExpression, c PlusExpression (지금 여기서 VariableExpression 는 뺌)
        // 이거 스택으로 쌓는 개념이 아니라 "집합"처럼 Expression 식을 감싸면서 진행하는 것임

        // 마지막에는 최종 연산 숫자만 남음 -> 그걸 pop 하는 것임  = 이게 최종 연산임
        return stack.pop();
    }

    private static PostfixExpression getExpression(char c, Stack<PostfixExpression> stack) {

        //(+, -)연산 외에 또다른 여산이 추가 된다고 하면 클라이언트 코드 건드릴 필요 없이 여기에서만 추가하면 됨
        //ex) *, / 등등
        switch (c) {
            case '+':
                return new PlusExpression(stack.pop(), stack.pop());

            case '-': //더하기는 왼쪽 오른쪽 순서를 바꿔도 상관 없지만 뺄셈은 왼쪽, 오른쪽 순서 중요함, 그래서 left, right 을 구분해 놓음
                PostfixExpression right = stack.pop();
                PostfixExpression left = stack.pop();
                return new MinusExpression(left, right);

            default:
                return new VariableExpression(c);
        }

    }
}
























