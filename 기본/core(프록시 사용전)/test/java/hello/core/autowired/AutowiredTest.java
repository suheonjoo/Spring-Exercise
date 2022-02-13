package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        //여기 안에 TestBean을 넣어주면 스프링 빈으로 등록됨ㅋ
        //등록한거만 볼려고 아래 클래스 만든거

    }

    static class TestBean{

        //이거 만약에 true로 하면 터짐. 왜냐면 Member가 스프링 빈으로 등록되는게 아니기 때문에 찾을수 없다고 오류남
        //false면 1번자체가 호출이 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        //호출은 되는데 null로 들어간다
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        //애는 호출이 되는데 없으면 Optional.empty로 넣어준다 optional이 감싸줘서
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }



    }


}
