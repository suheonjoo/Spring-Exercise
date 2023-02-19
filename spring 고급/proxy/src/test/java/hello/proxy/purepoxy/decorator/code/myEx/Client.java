package hello.proxy.purepoxy.decorator.code.myEx;

import org.junit.jupiter.api.Test;

public class Client {

	/**
	 * Decorator 라는 추상클래스로 만들고, decorator 기능을 Decorator 상속을 받도록 구현하여
	 * 실제 컴포넌트 인지, 데코레이터인지 명확하게 구분할 수 있게 만든 예제이다
	 */
	@Test
	public void behaveTest() throws Exception{
	    //given
		Behave behave = new StarDecorator(new SmileDecorator(new Walk()));

	    //then
		behave.execute();
	}

}
