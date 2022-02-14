package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //여기를 http의 [status-line]이라고 부른다
        response.setStatus(HttpServletResponse.SC_OK); //직접 200을 넣어주는 것보다 일렇게 변수로 넣어주는 것이 낫다

        //[response-headers]
        //response.setHeader("Content-Type","text/plain;charset=utf-8");
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //캐시를 완전히 무효화 하겠다
        response.setHeader("Pragma","no-cache");
        response.setHeader("my-header","hello");//사용자 지정 헤더를 만들수도 있음


        //[Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);

        //[message body]
        PrintWriter writer = response.getWriter();//getWriter 또는 inputStream()으로도 할수 있음
        writer.println("ok");
        //여기서는 Content-Length: 3이다 println이라서 \n이 들어가서 2가 아니라 3인 것임

    }

    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2

        //response.setHeader("Content-Type", "text/plain;charset=utf-8")를 아래 두줄로 바꿀수 있다
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //이거 생략시 자동 생성
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600; 이런식으로 쿠키를 넣고 싶을 것임

        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        //위와 같이 하는데 대신에 Cookie라는 객체를 이용해서 아래와 같이 할 설정할 것임
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
        //이렇게 응답메세지로 쿠키를 만들어주고 다시 페이지를 새로 고침하면 요청 헤더에 cookie 들어가 있음
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html 이렇게 만들 거임

        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html"); 이 두줄을 아래 한줄로 만들수 있음
        response.sendRedirect("/basic/hello-form.html");
    }

}
