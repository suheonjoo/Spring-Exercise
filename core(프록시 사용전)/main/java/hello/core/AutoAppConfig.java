package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(  //스프링 빈은 가져다 자동으로 끌로 와 주는 것
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //다 끌고 오는 외중에 그중주에 뺄것을 지정해 주는 것임
        //이전에 사용한 configuration을 빼줌 예제 보관을 위해 아까움
)//팁: shift 번 하면 여태 클래스들 검색할 수 있음
public class AutoAppConfig {
}
