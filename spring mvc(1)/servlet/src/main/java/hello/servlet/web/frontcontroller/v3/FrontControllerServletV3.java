package hello.servlet.web.frontcontroller.v3;

import hello.servlet.basic.HelloServlet;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HelloServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    //이렇게 controller를 저장해서 꺼내쓸수 있게 만듬
    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members",new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //요청된 url을 받음
        String requestURI = request.getRequestURI();
        //여기서 getRequestURI를 uri로 받아야지 url로 받으면 안됨  나 이래서 오류났음

        //그러면 해당 controller가 찾아짐
        ControllerV3 controller = controllerMap.get(requestURI);
        //만약 없으면 예외처리
        if(controller==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }


        //paraMap 맵에서 파라미터를 다 꺼내야 함
        Map<String, String> paramMap = createParamMap(request);


        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();//논리이름 new-form

        //이것도 그냥 만들다가 단축키로 메서드 따로 추출해줌
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(),request,response);

    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();

        //이거 너무 디테일함 그러면 따로 메서드를 추출해줘도됨
        //단축키 command option m
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
