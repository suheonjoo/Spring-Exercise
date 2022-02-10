package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//공연기획자 역할임
@Configuration
public class AppConfig {



    //이거 command option m 으로 매소드 따로 추출해줌
    //여기서 @Bean("이름")이름 만들어 줄수 있음 그러면
    //applicationContext.getBean("memberService", MemberService.class);에서도 앞에 이름 바꿔줘야함 근데 관례상 그냥 기본값으로 함
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    //이렇게 @Bean을 해주면 다 스프링 컨테이너에 등록여기서 해줌
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }


    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return  new RateDiscountPolicy();
    }


}
