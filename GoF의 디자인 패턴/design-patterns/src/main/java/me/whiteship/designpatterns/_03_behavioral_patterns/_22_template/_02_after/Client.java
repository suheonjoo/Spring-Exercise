package me.whiteship.designpatterns._03_behavioral_patterns._22_template._02_after;

public class Client {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new Multiply("number.txt");
        int result = fileProcessor.process((sum, number) -> sum += number);// 템플릿 콜백 패턴
        //int result = fileProcessor.process();// 템플릿 메서드 패턴
        System.out.println(result);
    }
}
