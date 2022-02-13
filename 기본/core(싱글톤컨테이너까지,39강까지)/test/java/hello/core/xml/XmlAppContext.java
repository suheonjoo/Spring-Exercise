package hello.core.xml;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions; //이게 asserthat 생성하는 것임
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {

    @Test
    void XmlAppContext(){
        //어차피 GenericXmlApplicationContext는 ApplicationContext소속이라 ApplicationContext로 정의해도 됨
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }

}
