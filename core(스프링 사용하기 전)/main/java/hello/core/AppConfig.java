package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Configuration;

//공연기획자 역할임

public class AppConfig {



    //이거 command option m 으로 매소드 따로 추출해줌
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());

    }

    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    //결국 기획자를 통해서 필요한 구현체를 다 생성, 역할을 입해준다
    //OrderServiceImpl 에는 MemoryMemberRepository , FixDiscountPolicy 객체의 의존관계가 주입된다
    //command d 과거 했더 클래스, 인터페이스 등등 다 나옴

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return  new RateDiscountPolicy();
    }


}
