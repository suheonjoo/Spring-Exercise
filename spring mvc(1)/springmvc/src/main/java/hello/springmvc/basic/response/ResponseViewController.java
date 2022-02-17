package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data","hello!");
        return mav;
    }

    //@ResponseBody로 하면 상대결로로 가는게 아니라 그냥 리턴값이 출력됨->메세지 컨버터 동작함
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data","hello!");

        return "response/hello";
    }

    //이거는 절대 권장하지 않음 , 너무 불명확해서
    //컨트롤러의 이름과 논리 경로의 이름이 같으면 되게 해줌 반환값이 논리 경로로 진행해줌
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data","hello!");

    }
}
