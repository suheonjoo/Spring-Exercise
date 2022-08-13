package me.whiteship.designpatterns._02_structural_patterns._11_flyweight._01_before;

public class Client {

    public static void main(String[] args) {

        //여기보면 겹치는 속성이 굉장히 많음
        Character c1 = new Character('h', "white", "Nanum", 12);
        Character c2 = new Character('e', "white", "Nanum", 12);
        Character c3 = new Character('l', "white", "Nanum", 12);
        Character c4 = new Character('l', "white", "Nanum", 12);
        Character c5 = new Character('o', "white", "Nanum", 12);
    }
}
