package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class); //나 이거 beanA를 BeanA라고 해서 오류남 조심
        assertThat(beanA).isNotNull();


        //이건 junit으로
        assertThrows(
                NoSuchBeanDefinitionException.class,
                ()->ac.getBean("beanB",BeanB.class));
    }

    //annotation필터에 관한 필터를 만드는 것임//@ComponentScan.Filter 이거 static import 할수 있음->@Filter
    //type = FilterType.ANNOTATION는 기본값이라서 사실 없어도 잘 동작한다
    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION,classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION,classes = MyExcludeComponent.class))
    static class ComponentFilterAppConfig{//이렇게하면 나만의 componentscan할수 있는 필터가 만들어짐

    }

}
