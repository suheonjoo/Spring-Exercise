package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.argumentresolver.Login;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    //@GetMapping("/")
    public String home() {
        return "home";
    }

    //@GetMapping("/")
    public String homeLogin(@CookieValue(name = "memberId",required = false) Long memberId, Model model){
        if(memberId==null){
            return "home";
        }

        Member loginMember = memberRepository.findById(memberId);
        if(loginMember==null){
            return "home";
        }

        model.addAttribute("member",loginMember);
        return "loginHome";
    }

    //@GetMapping("/")
    public String homeLoginV2(HttpServletRequest request, Model model){

        //세션 관리자에 저장된 회원 정보를 조회
        Member member = (Member) sessionManager.getSession(request);

        if(member==null){
            return "home";
        }

        model.addAttribute("member",member);
        return "loginHome";
    }



    //@GetMapping("/")
    public String homeLoginV3(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);
        if(session==null){
            return "home";
        }
        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        //세션에 회원데이터가 없으면 home
        if(loginMember==null){
            return "home";
        }
        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member",loginMember);
        return "loginHome";
    }

   //@GetMapping("/")
    public String homeLoginV3Spring(//이미 로그인 된 사용자를 찾을 때 @SessionAttribute 사용함
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false) Member loginMember, Model model){

        //세션에 회원데이터가 없으면 home
        if(loginMember==null){
            return "home";
        }

        //세션이 유지되면 로그인으로 이동
        //추가로 홈 화면에 화원 관련 정보도 출력해야 해서 member 데이터도 모델에 담아서 전달한다.
        model.addAttribute("member",loginMember);
        return "loginHome";
    }

    



    @GetMapping("/")
    public String homeLoginV3ArgumentResolver(@Login Member loginMember, Model model){

        log.info("loginMember={}",loginMember);
        //세션에 회원데이터가 없으면 home
        if(loginMember==null){
            return "home";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member",loginMember);
        return "loginHome";
    }



}