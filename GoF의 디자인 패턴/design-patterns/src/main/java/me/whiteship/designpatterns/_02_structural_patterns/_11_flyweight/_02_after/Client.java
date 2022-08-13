package me.whiteship.designpatterns._02_structural_patterns._11_flyweight._02_after;

public class Client {

    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        Character c1 = new Character('h', "white", fontFactory.getFont("nanum:12"));
        //fontFactory.getFont("nanum:12")을  공유하기 때문에 이만큼을 메모리를 덜 쓰게 되는 것임
        Character c2 = new Character('e', "white", fontFactory.getFont("nanum:12"));
        Character c3 = new Character('l', "white", fontFactory.getFont("nanum:12"));
    }
}
