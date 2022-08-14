package me.whiteship.designpatterns._03_behavioral_patterns._19_observer._03_java;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {//이벤트를 옵저버 하는 클래스

    @EventListener(MyEvent.class)
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event.getMessage());
    }
}
