package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

//control r이 이전에 run했던거 다시 run 해줌
@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount=1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){//여기서 enum 타입은 ==쓰는게 맞음
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
