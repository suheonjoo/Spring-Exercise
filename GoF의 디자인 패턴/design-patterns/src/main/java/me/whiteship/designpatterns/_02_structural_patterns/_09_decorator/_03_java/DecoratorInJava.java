package me.whiteship.designpatterns._02_structural_patterns._09_decorator._03_java;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecoratorInJava {

    public static void main(String[] args) {
        // Collections가 제공하는 데코레이터 메소드
        ArrayList list = new ArrayList<>();
        list.add(new Book());

        //Book 클래스 타입만 들어갈수 있게 하는 것임-> 안에 들어가보면 checkedList 로 감싸는 것을 볼 수 있음
        //-> 이것도 데코레이터 패턴임
        List books = Collections.checkedList(list, Book.class);


//        books.add(new Item());

        List unmodifiableList = Collections.unmodifiableList(list);

        list.add(new Item());

        //unmodifiableList 로 설정해서 수정할수 없음 아래 코드 하면 에러남ㅋ
        unmodifiableList.add(new Book());


        // 서블릿 요청 또는 응답 랩퍼
        // 실제로 안에 들어가보면 주석에 데코레이터 패턴이라고 적혀 있음
        HttpServletRequestWrapper requestWrapper;
        HttpServletResponseWrapper responseWrapper;
    }

    private static class Book {

    }

    private static class Item {

    }
}
