package hello.aop.exam.internalcall;

import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV0 {
    public void external() throws NoSuchMethodException {
        log.info("call external");
        internal(); //내부 메서드 호출(this.internal())
    }
    public void internal() {
        log.info("call internal");
    }
}