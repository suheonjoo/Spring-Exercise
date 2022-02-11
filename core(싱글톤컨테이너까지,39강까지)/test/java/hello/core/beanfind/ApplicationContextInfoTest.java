package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter tab 단축키 활용함(리스트 배열 자동으로 포문 만들어줌)
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            //단축키 soutv 변수명 출력 , soutm 메소드 출력
            System.out.println("name = " + beanDefinitionName + "object = "+ bean);

        }
    }

    //command d오 위에꺼  복붙 할수 있음
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter tab 단축키 활용함(리스트 배열 자동으로 포문 만들어줌)
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //ROLE_APPLICATION : 일반적으로 사용자가 정의한 빈
            //ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            //이거는 스프링 내부에서 뭔가 할려고 한 빈들이 아니라 애플리케이션을 주로 개발하기 위해서 만든 빈들,또는 외부 라이브러리 등등
            if(beanDefinition.getRole()==beanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                //단축키 soutv 변수명 출력 , soutm 메소드 출력
                System.out.println("name = " + beanDefinitionName + "object = "+ bean);


            }
        }


    }



}
