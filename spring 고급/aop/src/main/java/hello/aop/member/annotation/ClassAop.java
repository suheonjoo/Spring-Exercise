package hello.aop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//클래스에 붙이는 애노테이션이라는 것임
@Retention(RetentionPolicy.RUNTIME)//런타임이 실행될때까지 살아 있는 거임
public @interface ClassAop {
}
