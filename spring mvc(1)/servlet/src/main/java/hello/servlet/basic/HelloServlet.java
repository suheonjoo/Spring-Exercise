package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//여기 있는 namer과 urlPatterns는 다른 것과 겹치면 안됨
@WebServlet(name = "helloServlet", urlPatterns = "/hello") //'/hello'가 오면 아래 함수가 실행되는 것임
public class HelloServlet extends HttpServlet {

    //단축키 ctrl o로 만듦
    //이렇게 만들어주면: service를 호출하게 되면 이 서비스 메서드가 호출이 된
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response); //이거 찍힐려면 다시 /hello로 들어가야함

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //아래 2개는 http 헤더 정보에 들어가는 것임
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); //굉장히 옛날 시스템이 아니면 utf-8을 써야 함
        response.getWriter().write("hello "+ username);

        //http 요청메세지 다 보고 싶을때 넣어주는 것, 근데 이거 요청할대마다 이렇게 되면 성능 저하문제 생김 -> 개발할때만 사용해라
        //application.propoerties에 logging.level.org.apache.coyote.http11=debug 추가해줌


    }
}
