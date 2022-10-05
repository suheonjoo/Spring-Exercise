package hello.hellospring.controller1;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @PostMapping("/test")
    public TestDto testDto(@RequestBody TestForm testForm) {


        TestDto testDto = new TestDto(testForm.getTestDetailDto());

        return testDto;
    }

    @ResponseBody
    @PostMapping("/test1")
    public Test2Form test(@RequestBody Test2Form test2Form) {

        System.out.println("test2Form = " + test2Form.toString());

        return test2Form;

    }

    @GetMapping("/")
    public String home() {
        return "home";
    }


}
