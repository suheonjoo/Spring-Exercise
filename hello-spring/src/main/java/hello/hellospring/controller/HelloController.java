package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //여기서 보면 getmapping은 get 방식으로 넘어오는 것임
    //postmapping은 post 방식으로 넘어오는 것임
    //->그후 이렇게 넘어오고 각각 아래 있는 메소드가 호출이 됨
    //그러면서 매개변수로 값(폼에서 받아온 값)이 들어옴
    @GetMapping("hello")//hello.html에서 get으로 넘어왔을때 아래 함수 실행함
    public String hello(Model model){//스프링에서는 html의 attribute을 스프링에 내장되어있는 model이라는 객체에 전달해준다
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        //여기서 required가 기본으로 적용됨@RequestParam(value="name",required=True)
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //html의 body 아님
    public String helloString(@RequestParam("name") String name){

        return "hello" + name;
    }

    //여기서 responsebody는 http의 헤더와 바디 중 바디부분이다
    //바디 부분에 리턴 값을 직접 넣어주겠다는 것임
    //@Responsebody가 있으면 그냥 html을 그대로 넘겨주어야 한다고 동작을 한다
    //자세히 말하면 객체로 넘기고 조건을 보고 htmlmessageconverter가 동작을 함
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }//여기서 리터값을 객체로 넘겨줌
    //여기서 객체로 넘져주면 json으로 넘어가서 화면에 보여줌
    //json은 key, value로 이루어진 구조이다
    //xml방식은 열고 닫고 2번 써야 함 그래서 요즘에는 json방식으로 거의 통일함
    //그래서 위에처럼 @responsebody하고 객체로 반환하여 json으로 가는게 기본이다
    //(객체를 json으로 바꾸주는 라이브러리가 있는데 MappingJackson2HttpMessageConverter가 있고 구글에서 만든 g슨? 이 있다)

    public class Hello{
        private String name;

        //여기에 있는 getter and setter을 command enter 단축키로 생성
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        //위와 같은 getter and setter방식을 proporty 접근 방식이라고 한다
    }



}





