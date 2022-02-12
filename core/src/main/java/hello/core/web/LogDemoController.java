package hello.core.web;


import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    //private final MyLogger myLogger;//이거 쓰면 생성과 동싱에 요청도 없는데 요청받아야한다고 해서 오류남
    private final ObjectProvider<MyLogger> myLoggerProvider;    //그래서 provider개념을 쓰는 것됨

    @RequestMapping("log-demo")
    @ResponseBody//지금 view 화면이 없음 그래서 그냥 문자로 바로 반환할꺼여서 이거 어노테이션 함
    public String logDemo(HttpServletRequest request){

        //이러면 고객이 어떤 url로 request했는지 알수 있음
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLoggerProvider.getClass() = " + myLoggerProvider.getClass());
        
        //여기서 myLogger를 받는 것임
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}
