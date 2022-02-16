package hello.servlet.web.servletmvc.springmvc.v1;


import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//controller안에 @Component가 있어서 자동으로 스프링빈에 등록됨
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }


}
