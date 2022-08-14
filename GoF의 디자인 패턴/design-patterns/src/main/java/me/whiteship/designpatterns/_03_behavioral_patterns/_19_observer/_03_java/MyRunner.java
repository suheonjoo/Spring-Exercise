package me.whiteship.designpatterns._03_behavioral_patterns._19_observer._03_java;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {//스프링부트가 애플리케이션을 띄었을 때 자동으로 자동으로 실행하는 코드를 넣어주고 싶을 때 씀

    //ApplicationContext로 받아도 되는게 여기강의에서 구체적인 의도 를 나타내기 위해서 ApplicationEventPublisher 쓴 것
    private ApplicationEventPublisher publisher;
    public MyRunner(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        publisher.publishEvent(new MyEvent("hello spring event"));
    }
}
