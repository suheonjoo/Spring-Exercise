package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        /*
        //ThreadA: A사용자가 10000원을 주문함
        statefulService1.order("userA",10000);
        //ThreadB: B사용자가 20000원을 주문함
        statefulService2.order("userB",20000);

        //ThreadA: 사용자A 주문 금액 조회
        int price = statefulService1.getPrice();
        //지금 상황이 a가 주문학고 금액을 조회하는 사이에 b가 주문한 것임
        System.out.println("price = " + price);
        //그러면 결과는 당연히 2만원이 나온다 : 우리는 만원이 나오기를 기대함
        //이유는 들어가면 instance는 같은 것을 쓰기 때문임

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
        //이러면 서비스 ㅈ망함는 것임
        */

        //무상태로 설계 //(지역변수로 함)
        //ThreadA: A사용자가 10000원을 주문함
        int userAPrice = statefulService1.order("userA",10000);
        //ThreadB: B사용자가 20000원을 주문함
        int userBPrice = statefulService2.order("userB",20000);

        System.out.println("price = " + userAPrice);


    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}

















