package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath ="/WEB-INF/views/new-form.jsp";
        //controller에서 view로 이동할때 사용하는 것임
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //이걸(forward) 호출하면 servlet에서 jsp를 호출할 수 있음
        dispatcher.forward(request,response);
    }
}
