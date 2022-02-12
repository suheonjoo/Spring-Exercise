package hello.core.common;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)//'value =' 는 빼도 됨
public class MyLogger {//위에처럼 하면 가짜를 만드는 것임 = proxy를 만드는 것임

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("["+ uuid + "]"+ " ["+requestURL+"] "+" ["+message+"] ");
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();//이건 전세개에서 유일함 중복X
        System.out.println("["+ uuid + "] request scope bean create: "+this);
        //this를 붙여줘서 주소까지 나오게 해줌
    }

    @PreDestroy
    public void close(){
        System.out.println("["+ uuid + "] request scope bean close: "+this);
    }


}
