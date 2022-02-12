package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


class ApplicationContextBasicFindTest {

    //이거 command e 단축키로 이전코드로 넘어가는 거에서 복붙함
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    //이건 인터페이스를 조회하면 인터페이스(MemberService)가 구현체의 대상이 됨

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        //타입으로만 조회할수 있어서 이름을 빼줌
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        //타입으로만 조회할수 있어서 이름을 빼줌
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        //사실 역할에 의존해야 하는데 위에는 구현에 의존하것 것이기에 좋은 것은 아님
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        //MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxxx", MemberService.class));
        //오른쪽에 로직을 실행하면 왼쪽에 있는 것이 터져야 하는 것 안터지며 실패하는 것임

    }

}
