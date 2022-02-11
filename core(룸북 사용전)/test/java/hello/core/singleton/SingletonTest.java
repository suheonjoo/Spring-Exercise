package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest  {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2이어야 한다
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 사용한 객체 사용")
    void singletonServiceTest(){
        //이렇게 하면 당연히 안됨 private으로 지정했잖음
        //SingletonService singletonService1 = new SingletonService();

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        //isSameAs, isEqualto 차이
        //same는 ==을 의미 즉, 인스턴스 비교를 의미
        //equal는 equal라는 매서드를 의미함
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회: 호출할때마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);

        //2. 조회: 호출할때마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2이어야 한다
        assertThat(memberService1).isSameAs(memberService2);
    }


}
