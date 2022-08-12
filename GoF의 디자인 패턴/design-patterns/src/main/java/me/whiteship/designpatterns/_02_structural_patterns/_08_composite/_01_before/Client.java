package me.whiteship.designpatterns._02_structural_patterns._08_composite._01_before;

import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) {
        Item doranBlade = new Item("도란검", 450);
        Item healPotion = new Item("체력 물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healPotion);

        Client client = new Client();
        client.printPrice(doranBlade);
        client.printPrice(bag);
    }

    //클라이언트 클래스에 bag, item 세부 내용이 있는 것임 이건 객체 지향적으로 문제 있음
    //-> 그래서 이후에 클라이언트는
    private void printPrice(Item item) {
        System.out.println(item.getPrice());
    }

    private void printPrice(Bag bag) {
        int sum = bag.getItems().stream().mapToInt(Item::getPrice).sum();
        System.out.println(sum);
    }

}
