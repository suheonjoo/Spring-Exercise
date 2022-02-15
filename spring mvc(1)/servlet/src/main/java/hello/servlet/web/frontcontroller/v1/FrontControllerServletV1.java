package hello.servlet.web.frontcontroller.v1;

import hello.servlet.basic.HelloServlet;
import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1",urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HelloServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    //이렇게 controller를 저장해서 꺼내쓸수 있게 만듬
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form",new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save",new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members",new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");
        //요청된 url을 받음
        String requestURI = request.getRequestURI();
        //여기서 getRequestURI를 uri로 받아야지 url로 받으면 안됨  나 이래서 오류났음

        //그러면 해당 controller가 찾아짐
        ControllerV1 controller = controllerMap.get(requestURI);
        //만약 없으면 예외처리
        if(controller==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        controller.process(request,response);

    }
}
