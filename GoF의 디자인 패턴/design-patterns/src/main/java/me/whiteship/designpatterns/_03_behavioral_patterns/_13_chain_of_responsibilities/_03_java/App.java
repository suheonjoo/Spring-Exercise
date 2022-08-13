package me.whiteship.designpatterns._03_behavioral_patterns._13_chain_of_responsibilities._03_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan// 서블릿을 스캔해서 빈을 등록해줌 여기서 @WebFilter(urlPatterns = "/hello")를 스캔해줌
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
