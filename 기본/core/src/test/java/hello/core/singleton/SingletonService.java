package hello.core.singleton;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//싱글톤 패턴 예시이다 (싱글톤: 클래스의 인스턴스가 한개, 디자인 패턴중 하나)
public class SingletonService {

    //자기 자신을 내부의 private, static으로 가지고 있다
    private static final SingletonService instance = new SingletonService();
    //이러면 자바가 뜰때 바로 객체 자기자신을 만들고 instance로 넣어놓음 (즉 먼저 하나 만들어놓음 더이상은 만들지 않을 것임)

    //조회할때 아래 메소드를 쓰면 됨 //public으로 열어서 객체 인스턴스가 필요하면 이 static 메소드 통해서만 조회할수 있다
    public static SingletonService getInstance(){
        return instance;
    }

    //private 생성자를 써서 new로 새로운 객체를 더 못만들게 함 하나만 있게 함
    private SingletonService(){

    }//이 private을 보고 싱글톤이구나 유추할수 있음

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}


