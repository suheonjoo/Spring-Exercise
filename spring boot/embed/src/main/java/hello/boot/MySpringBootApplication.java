package hello.boot;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //클래스 위에 쓸수 있게 한다
@Retention(RetentionPolicy.RUNTIME)
@Documented //문서화가 되도록 Document
@ComponentScan
public @interface MySpringBootApplication {

}