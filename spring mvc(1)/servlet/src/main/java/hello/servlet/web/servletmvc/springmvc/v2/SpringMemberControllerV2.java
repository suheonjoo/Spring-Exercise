package hello.servlet.web.servletmvc.springmvc.v2;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")//이걸로 중복되는 부분 제거할수 있음
public class SpringMemberControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm(){
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");

        //mv.getModel().put("member",member);를 아래처럼 간단하게 바꿀수 있따
        mv.addObject("member",member);
        return mv;
    }

    @RequestMapping// ("/")이렇제 해도 오류임 그냥 지우면 됨
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");

        //mv.getModel().put("members",members);
        mv.addObject("members",members);
        //여긴 멤버''들''을 받는거라 member가 아닌 members임

        return mv;
    }




}
