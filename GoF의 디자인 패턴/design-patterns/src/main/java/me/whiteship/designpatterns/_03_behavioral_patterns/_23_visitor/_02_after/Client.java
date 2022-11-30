package me.whiteship.designpatterns._03_behavioral_patterns._23_visitor._02_after;

public class Client {

    public static void main(String[] args) {
        /**
         * Shape 에는 rectangle, circle 이 있었음
         */
        Shape rectangle = new Rectangle();

        /**
         * Device 에는 Pad 와 Phone 이 있음
         */
        Device device = new Pad();
        rectangle.accept(device);
    }
}















