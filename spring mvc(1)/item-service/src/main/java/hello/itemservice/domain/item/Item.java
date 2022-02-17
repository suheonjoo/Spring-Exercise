package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data //이거 쓰면 getter setter tostring 등등 다 만들어줌 그래서 위험함! 근데 예지니깐~
public class Item {

    private Long id;
    private String itemName;
    private Integer price; //integer쓰는 이유는 null도 고려한 것임
    private Integer quantity;

    public Item(){}

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
