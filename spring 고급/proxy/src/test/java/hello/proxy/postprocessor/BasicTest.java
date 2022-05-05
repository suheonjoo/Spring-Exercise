package hello.proxy.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BasicTest {

    @Test
    void basicConfig() {
        //이거 자체가 스프리 컨테이너임//그래서 여기에 BasicConfig를 넣어주면 스프링 빈으로 등록 되는 것임
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BasicConfig.class);


        //A는 빈으로 등록된다.
        A a = applicationContext.getBean("beanA", A.class);
        a.helloA();
        //B는 빈으로 등록되지 않는다.
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(B.class));
        //NoSuchBeanDefinitionException이 터져야 뒤에 있는 람다가 실행되는 것임
    }

    @Slf4j
    @Configuration
    static class BasicConfig {
        @Bean(name = "beanA")//beanA라는 이름으로 빈 등록
        public A a() {
            return new A();
        }
    }

    @Slf4j
    static class A {
        public void helloA() {
            log.info("hello A");
        }
    }

    @Slf4j
    static class B {
        public void helloB() {
            log.info("hello B");
        }
    }


}














