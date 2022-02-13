package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //type이라고 지정해서 클래스 레벨에 붙는 것이다
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {//얘가 붙은 것은 componentscan에 추가할꺼야 라는 의미임
}
