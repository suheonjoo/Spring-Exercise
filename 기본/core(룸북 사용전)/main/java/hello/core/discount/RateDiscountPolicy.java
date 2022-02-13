package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    //여기서 테스트코드를 만들고 싶을 때 command shift t 를 누르면 됨 그럼 이름하고 패키지도 새로 생성해줌
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price*discountPercent/100;
        }else {
            return 0;
        }
    }
}
