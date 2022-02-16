package hello.servlet.web.servletmvc.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping(value = "/new-form",method = RequestMethod.GET)아래처럼 간략화가능
    @GetMapping("/new-form")
    public String newForm(){
        return "new-form";
    }

    //@RequestMapping(value = "/save",method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {


        Member member = new Member(username, age);
        memberRepository.save(member);

        //mv.addObject("member",member);
        model.addAttribute("member",member);
        return "save-result";
    }

    //@RequestMapping(method = RequestMethod.GET)// ("/")이렇제 해도 오류임 그냥 지우면 됨 -> 여기서는 그냥 넘겨도 가능
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members",members);

        return "members";
    }


}
