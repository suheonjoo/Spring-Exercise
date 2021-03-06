package hello.login.web.login;

import hello.login.domain.login.LoginService;
import hello.login.domain.member.Member;
import hello.login.web.SessionConst;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form){
        //log.info("form = {}", LoginForm);//오류남 당연히
        log.info("form = {}", form);
        return "login/loginForm";

    }

    //@PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }
        //LoginForm에 @Data를 해줘야 get으로 접근 가능
        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if(loginMember==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //로그인 성공

        //쿠키에 시간 정보를 주지 않으면 세션 쿠기(브라우저 종료시 모두 종료)
        Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getId()));
        response.addCookie(idCookie);

        return "redirect:/";
    }


    //@PostMapping("/login")
    public String loginV2(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }
        //LoginForm에 @Data를 해줘야 get으로 접근 가능
        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if(loginMember==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //로그인 성공

        //세션 관리자를 통해 세션을 생성하고, 회원데이터를 보관
        sessionManager.createSession(loginMember,response );


        return "redirect:/";
    }


    //@PostMapping("/login")
    public String loginV3(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }
        //LoginForm에 @Data를 해줘야 get으로 접근 가능
        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if(loginMember==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //로그인 성공
        //세션이 있으면 있는 세션을 반환, 없으면 신규 세션을 생성해서 반환함
        //서블릿이 제공하는 세션임 (HttpSession)
        HttpSession session = request.getSession();
        //세션의 로그인 회원정보를 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER,loginMember);

        //세션 관리자를 통해 세션을 생성하고, 회원데이터를 보관
        //sessionManager.createSession(loginMember,response );

        return "redirect:/";
    }



    @PostMapping("/login")
    public String loginV4(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
                          @RequestParam(defaultValue = "/") String redirectURL,
                          HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login/logiForm";
        }
        //LoginForm에 @Data를 해줘야 get으로 접근 가능
        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if(loginMember==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //로그인 성공
        //세션이 있으면 있는 세션을 반환, 없으면 신규 세션을 생성해서 반환함
        HttpSession session = request.getSession();
        //세션의 로그인 회원정보를 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER,loginMember);

        //세션 관리자를 통해 세션을 생성하고, 회원데이터를 보관
        //sessionManager.createSession(loginMember,response );

        return "redirect:"+redirectURL;
    }

    //@PostMapping("/logout")
    public String logout(HttpServletResponse response){
        expireCookie(response,"memberId");
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logoutV2(HttpServletRequest request){

        //sessionManager.expire(request)

        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response,String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}




