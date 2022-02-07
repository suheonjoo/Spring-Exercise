package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    //final은 한 정해놓은 것을 수정할 수 없게 함
    private final MemberService memberService;
    //private final MemberService memberService = new MemeberService
    //컨트롤러 안에 위와 같이 memberservice를 만들 필요 없음
    //즉 객체를 또 만들 필요가 없다는 것임
    //하나의 객체로만 관리해도 된다는 것임


    //@Autowire는 스프링 컨테이너안에 있는 멤버서비스를 가져다 연결을 시켜줌
    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }
    //근데 오류 발생만
    //MemberService는 순수 자바 클래스임
    //스프링이 얘를 알수 있는 방법이 없음(즉 @이가 없는 순수자바 코드라는 것임)
    //MemberService 위에 @Service를 넣어준다

    @GetMapping(value = "/members/new")
    public String createForm() {

        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }


    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
