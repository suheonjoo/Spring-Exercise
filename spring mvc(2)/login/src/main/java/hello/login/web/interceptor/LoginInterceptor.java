package hello.login.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    //control o 로 오버라이드 호출
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        //상수로 만드는 단축키를 몰라 control t 로 검색해서 상수로 만듦
        request.setAttribute(LOG_ID,uuid);

        //@RequestMapping를 사용하면 HandlerMethod가 넘어오고
        //정적 리소스를 사용하면 ResourceHttpRequestHandler가 넘어온다
        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;//호출할 컨트롤러의 메서드의 모든 정보가 포함되어 있음
        }

        log.info("REQUEST [{}][{}][{}]",uuid,requestURI,handler);
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle [{}]",modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        Object logId = (String) request.getAttribute("logId");
        log.info("REQUEST [{}][{}][{}]",logId,requestURI,handler);
        if(ex!=null){
            log.error("afterCompletion error!!",ex); //오류는 {}안해줘도 됨
        }
    }
}
