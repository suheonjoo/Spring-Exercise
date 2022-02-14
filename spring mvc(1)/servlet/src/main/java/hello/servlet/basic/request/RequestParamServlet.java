package hello.servlet.basic.request;

import hello.servlet.basic.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 1.파라미터 전송기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 */
@WebServlet(name = "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HelloServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getParameterNames(); //이렇게 하면 모든 요청파라미터를 다 꺼낼수 있다
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println("paramName = " + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        //여러 파라미터를 꺼낼때 getParameterValues로 꺼내면 된다 중복상황에서사용 중복상황동 아닌데 getParameter는 못씀
        String[] usernames = request.getParameterValues(username);
        //단축키 iter이용
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

        response.getWriter().write("ok");

    }
}
