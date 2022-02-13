package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {


    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);

        //여기 중요한데 ConfigurableApplicationContext를 선언하더가 AnnotationConfigApplicationContext로 선언하던가
        //ApplicationContext에서 ->AnnotationConfigApplicationContext에서-> ConfigurableApplicationContext (하위 인터페이스임)
        //보통 애플리케이션을 직접쓸때 close할 일이 없기 때문에 기본으로 제공해주지 않아서 기본 ApplicationContext에서 제고하지 않음 하위로 내려가야함
        ac.close();

    }

    @Configuration
    static class LifeCycleConfig{

        //@Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }


}
