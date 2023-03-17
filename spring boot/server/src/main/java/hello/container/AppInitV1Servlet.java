package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

/**
 * http://localhost:8080/hello-servlet
 */
public class AppInitV1Servlet implements AppInit {
	@Override
	public void onStartup(ServletContext servletContext) {
		System.out.println("AppInitV1Servlet.onStartup");
		//순수 서블릿 코드 등록 - 우리가 만들었더 서블릿 HelloServlet 를 등록해준다
		// HelloServlet 을 서브릿 컨테이너에 넣는다
		ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet", new HelloServlet());
		helloServlet.addMapping("/hello-servlet");
	}
}