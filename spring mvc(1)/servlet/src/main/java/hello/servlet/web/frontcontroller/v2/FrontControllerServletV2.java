package hello.servlet.web.frontcontroller.v2;

import hello.servlet.basic.HelloServlet;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2",urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HelloServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    //이렇게 controller를 저장해서 꺼내쓸수 있게 만듬
    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form",new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save",new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members",new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //요청된 url을 받음
        String requestURI = request.getRequestURI();
        //여기서 getRequestURI를 uri로 받아야지 url로 받으면 안됨  나 이래서 오류났음

        //그러면 해당 controller가 찾아짐
        ControllerV2 controller = controllerMap.get(requestURI);
        //만약 없으면 예외처리
        if(controller==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        MyView view = controller.process(request, response);
        view.render(request,response);

    }
}
