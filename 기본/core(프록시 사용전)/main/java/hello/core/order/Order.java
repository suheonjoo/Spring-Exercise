package hello.core.order;

public class Order {

    private Long memberId;  //회원 아이디
    private String itemName;    //아이템 이름
    private int itemPrice;      //아이템 가격
    private int discountPrice;  //할인 가격

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){//할인에 따른 계산된 가격을 리턴 할 것임
        return itemPrice - discountPrice;
    }


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    //그리고 이것을 출력할때 보기 쉽게 하기 위해서 toString() 사용할 것임
    //이것도 command n 단축키 이용
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }//이 객체를 선언하면 tostring이 쭉 나옴
    //예를들어 System.out.println(order)에서 order라는 객체를 생성하면 그에 대한 정보 위에처럼 다 출력해줌
}
