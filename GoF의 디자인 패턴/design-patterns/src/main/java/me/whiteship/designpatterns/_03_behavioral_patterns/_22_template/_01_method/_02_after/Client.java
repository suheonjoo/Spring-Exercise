package me.whiteship.designpatterns._03_behavioral_patterns._22_template._01_method._02_after;

public class Client {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new Multiply("number.txt");

        /**
         *  템플릿 메서드 패턴
         */
        int result = fileProcessor.process();
        System.out.println(result);
    }
}





























