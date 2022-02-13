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

    //@Bean memberService ->  new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //이렇게 되서 혹시 싱글톤이 깨지지 않을까?

    //호출을 출력해보면 예상 출력은
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository 이렇게 총 3번 call AppConfig.memberRepository가 호출되지 않나?

    //그런데
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //아 이걸보면 스프링이 어떠한 방법으로든 싱글톤을 보장해주는 구나!


    //이거 command option m 으로 매소드 따로 추출해줌
    //여기서 @Bean("이름")이름 만들어 줄수 있음 그러면
    //applicationContext.getBean("memberService", MemberService.class);에서도 앞에 이름 바꿔줘야함 근데 관례상 그냥 기본값으로 함
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    //이렇게 @Bean을 해주면 다 스프링 컨테이너에 등록여기서 해줌
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }


    @Bean
    public DiscountPolicy discountPolicy(){ //여기에는 2가지 선택 옵션이 있음
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
