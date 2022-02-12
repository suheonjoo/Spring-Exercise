package hello.core.lifecycle;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//javax는 자바에서 공식적으로 지원하는 것임

public class NetworkClient {

    private String url;

    public NetworkClient() {

        System.out.println("url = " + url);
        connect();
        call("초기화 연결 메세지");

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("url: "+ url +" message: " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("clos: " + url);
    }

    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }
    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }


/*
    //InitializingBean, DisposableBean 한테 상속 받을때
    @Override //애가 초기화 빈임//의존관계 주입이 끝나면 호출해 주겠다는 것임
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }
    @Override   //애가 들어보면 disconnect 호출해주는 거
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }

 */
}
