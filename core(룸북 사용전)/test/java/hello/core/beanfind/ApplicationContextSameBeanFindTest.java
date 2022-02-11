package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    //위 스프링 컨테이너가 뜰 때 괄호 안에 있는 config만 실행한다는 것임
    //그러면 아래 클래스 안에 2개만 등록하게 됨 그러면 아래 메소드에서 어떤것을 선택해야지 하면서 예외가 터지게 됨
    //->즉 말 그대로 같은 타입이 둘 이상 있어서 중복 오류가 발생한 것임

    @Test
    @DisplayName("타입으로 조회시 같이 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    void findBeanByTypeDuplicate(){
        //MemberRepository bean = ac.getBean(MemberRepository.class);
        //위를 호출했을 때, 예외가 터진다는 것임
        assertThrows(NoUniqueBeanDefinitionException.class,
                ()->ac.getBean(MemberRepository.class));
        //이 로직은 터져야지 성공 로직인것임
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")//아래 1,2모두 조회하고 싶을 때
    void findAllBeanByType(){
        //뒤에서 적고 command option v를 하면 map 형식 key, value 형식으로 나옴
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        //단축키 iter
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key+" value = "+ beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
        //타입이 2개 등록 되어 있으니깐 2개가 맞아야 함


    }



    @Test
    @DisplayName("타입 조회시 같은 타입이 둘 이상이면, 빈 이름을 지정하면 된다")
    void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }




    //클래스 안에 클래스를 썻다는 것은 이 클래스 안에서 만 쓰겠다는 것임
    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        //단축키 command d 로 똑같이 생성해
        //이렇게 bean의 이름이 다르고 객체의 instance 타입이 다를수 있음
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }

    }



}
