package hello.core.singleton;

//이거에 대한 테스트는 command shift t로 생성 (Junit5로 만임)
public class StatefulService {
    //주문을 할때 가격을 저장해주고 하는 거임

    /*private int price;  //상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name+ " price = "+ price);
        this.price = price; //여기가 문제가 됨
    }
    //주문하고 가격을 저장하고 꺼냄

    public int getPrice(){
        return price;
    }*/


    //무상태로 설계하는 법
    public int order(String name, int price){
        System.out.println("name = " + name+ " price = "+ price);
        //this.price = price; //여기가 문제가 됨
        return price;
    }
    //주문하고 가격을 저장하고 꺼냄


}
