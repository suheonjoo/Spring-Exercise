package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

// @HandlesTypes 애노테이션가 있어야
// public void onStartup(Set<Class<?>> c, ServletContext ctx) throws 메서드에서 Set<Class<?>> c 이것이 딸려 온다
@HandlesTypes(AppInit.class)
public class MyContainerInitV2 implements ServletContainerInitializer {
	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws
		ServletException {
		System.out.println("MyContainerInitV2.onStartup");
		System.out.println("MyContainerInitV2 c = " + c);
		System.out.println("MyContainerInitV2 container = " + ctx);
		for (Class<?> appInitClass : c) {
			try {
				//new AppInitV1Servlet()과 같은 코드
				//이거 리플랙선 사용해서 AppInit 의 구현체의 메서드를 실행하게 한 것이다 ㅋ
				AppInit appInit = (AppInit)
					appInitClass.getDeclaredConstructor().newInstance();
				appInit.onStartup(ctx);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}