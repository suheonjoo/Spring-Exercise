package hello.core.annotation;


import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

//이거 shift 2번 눌러서 @Qualify 검색해서 위에 @ 복붙 여기다 함
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {//그러면 이 어노테이션을 쓰면 위에꺼 컨테이너 안에서는 다 동작해줌
}
