package me.whiteship.designpatterns._03_behavioral_patterns._23_visitor._01_before;

public class Circle implements Shape {
    @Override
    public void printTo(Device device) {
        if (device instanceof Phone) { //이거 getClass로 코드 한줄로 바꿀수 있ㅇ므
            System.out.println("print Circle to phone");
        } else if (device instanceof Watch) {
            System.out.println("print Circle to watch");
        }
    }
}
