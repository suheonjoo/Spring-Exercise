package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    //이것도 단축키가 있는데 psvm치면 자동 생성해줌 이거 앞글자 따온거임
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        //근데 사실 여기서 문제가 되는 것음 추상화에도 의존하고 구현체에도 의존하는 것임-> 굉장히 안좋음 이건 dlp를 위반하고 있는 것임


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
