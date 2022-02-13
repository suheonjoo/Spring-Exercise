package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")//이렇게 사용하면 mainDiscountPolicy가 오타가 나도 동작함 그러면 뭐가 틀렸는지 모름
@MainDiscountPolicy//그래서 이렇게 지정해줌, 이건 MainDiscountPolicy 오타 나면 빨간줄 나옴
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
