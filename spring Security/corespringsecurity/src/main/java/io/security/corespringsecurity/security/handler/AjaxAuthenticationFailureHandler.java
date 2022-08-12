package io.security.corespringsecurity.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private ObjectMapper mapper = new ObjectMapper();
    
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

		String errorMessage = "Invalid Username or Password";

		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		if(exception instanceof BadCredentialsException) {
			errorMessage = "Invalid Username or Password";
		} else if(exception instanceof DisabledException) {
			errorMessage = "Locked";
		} else if(exception instanceof CredentialsExpiredException) {
			errorMessage = "Expired password";
		}

		//그리고 여기서 그먄 account 객체로 넘겨 줬는데 이거 dto로 바꿔서 넘겨주는게 좋다고 함 아니면 entity 그대로 보내게 되니깐
		mapper.writeValue(response.getWriter(), errorMessage);
	}
}
