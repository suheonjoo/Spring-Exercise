package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdf");

        String name = helloLombok.getName();
        System.out.println("name = " + name);

        //즉, 룸북은 getter, setter자동으로 만들어줌 원래는 getter and setter로 다짜워야 하는데
        //@Getter,@Setter하면 기본으로 내장되어 있음
        //또한 생성자 관련해서도 지원함 한번 룸북 검색해보삼, @toString 도 있고 위에 private으로 선언된것들 만들어줌
        //ex)
        System.out.println("helloLombok = " + helloLombok);


    }
}
