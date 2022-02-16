package hello.springmvc.basic;

import org.slf4j.Logger;//이걸써야함
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//그냥 @con능roller로 하면 view로 반환이 되는데 restcontroller로 하면 그냥 string으로도 반환 가
@RestController
public class LogTestController {
    //안에 또는 getClass()사용
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        //과거에는 이렇게 했음
        System.out.println("name = " + name);

        log.trace("trace log = {}",name);
        log.debug("debug log = {}",name);
        log.info("info log = {}",name);
        log.warn("warn log = {}",name);
        log.error("error log = {}",name);

        return "ok";

    }

}
