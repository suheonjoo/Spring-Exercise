package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    //GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    //GenericXmlApplicationContext 한 이유는 ApplicationContext로 하면 getBeanDefinition를 못사용함

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter 단축키
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = " + beanDefinitionName +
                        "beanDefinition = "+ beanDefinition);
            }
        }
    }
    //여기 결과를 보면 factorybean은 appconfig이고 팩토리 메소드는 memberservice임 즉 외부에서 가져오는 것임
    //즉AnnotationConfigApplicationContext에서 factoryBeanName=appConfig; factoryMethodName=memberService정보들이 팩토리빈을 통해서 제공된다

}
