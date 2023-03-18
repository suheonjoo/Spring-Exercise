package hello;

import hello.boot.MySpringApplication;
import hello.boot.MySpringBootApplication;

@MySpringBootApplication
public class MySpringBootMain {
	public static void main(String[] args) {
		System.out.println("MySpringBootMain.main");

		// 스프링 컨테이너에 MySpringBootMain 를 넣음으로서 @ComponentScan 기능을 쓰게 된다
		//MySpringBootMain 위에  @MySpringBootApplication 이 있고
		// @MySpringBootApplication 에는 @ComponentScan 가 있어서 현재 hello 패키지가 컴포넌트 스캔 대상이 되는 것이다
		// 이러한 @ComponentScan 적용 대상 클래스를 .run() 의 인자로 넘겨주고, .run() 안에 들어가면 해당 인자를 app.Context라는 스프링 컨테이너에 MySpringBootMain 를 넣어주는 모습이 된다
		MySpringApplication.run(MySpringBootMain.class, args);
	}

}