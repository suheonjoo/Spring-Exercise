package hello.aop.internalcall;

import hello.aop.exam.internalcall.CallServiceV0;
import hello.aop.exam.internalcall.aop.CallLogAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV0Test {
    @Autowired
    CallServiceV0 callServiceV0;

    @Test
    void external() throws NoSuchMethodException {
        callServiceV0.external();
    }

    @Test
    void internal() {
        callServiceV0.internal();
    }
}