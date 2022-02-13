package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10프로 할인이 되어야 한다") //한글로 이름을 써주는 기능임 //JUnit5부터 지원함
    void vip_o(){   //  vip 잘된다고 뒤에 o붙임
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
        //원래는 Assertions.assertThat인데 option enter로 on-demand static 으로 해놓은 것이 좋음
        //->그럼 아래것도 자동으로 됨 (이건 기본 문법이라 한번 찾아보삼)

    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){   //  vip 잘된다고 뒤에 o붙임
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);

    }

}