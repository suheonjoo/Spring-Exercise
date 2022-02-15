package hello.servlet.web.servletmvc;

import hello.servlet.basic.HelloServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet",urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HelloServlet {//애가 controller가 되는 것임
    //mvc 패턴은 항상 controller를 거쳐서 view 를 보여주는 것임
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath ="/WEB-INF/views/new-form.jsp";
        //controller에서 view로 이동할때 사용하는 것임
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //이걸(forward) 호출하면 servlet에서 jsp를 호출할 수 있음
        dispatcher.forward(request,response);

        //이건 로직이 없어도 무조건 controller를 통해서 가라고 규칙을 지켜줌
    }
}
