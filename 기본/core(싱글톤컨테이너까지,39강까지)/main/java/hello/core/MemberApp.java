package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    //이것도 단축키가 있는데 psvm치면 자동 생성해줌 이거 앞글자 따온거임
    public static void main(String[] args) {

        //스프링은 무조건 ApplicationContext로 시작함 얘가 @Bean객체들을 다 관래해주는 것임(스프링 컨테이너임)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //이렇게 AppConfig.class을 넣으면 AppConfig안에 설정 정보를 가지고 스프링빈에 객체(@Bena) 생성했던 것을 다 관리해 줌

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        //여기서도 팁인데 new 뒤부분만 작성하고 command option v하면 앞에 객체 자동으로 만들어주고 이름만 작성해주면 됨
        Member member = new Member(1L, "MemberA", Grade.VIP);//멤버 생성해줌
        //여기서 1L 붙여줘야함 long 타입
        memberService.join(member);//그리고 회원가입 해줌

        Member findMember = memberService.findMember(1L);

        System.out.println("new member= "+member.getName());
        System.out.println("find Member= "+findMember.getName());
        //soutv하고 commmand option v 하면 자동 생성

    }
}
