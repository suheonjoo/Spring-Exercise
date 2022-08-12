package io.security.corespringsecurity.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class FormAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {


        setDefaultTargetUrl("/");// 이거 부모클래스 꺼임, 왜냐면 자식이 오버라이드 해서 만들지 않았잖음
        // -> 이게 실제 구현체임 거기서 setter 로 url 설정 바꾼것임 그래서 모두 this, super. getDefault.. 하면 this 랑 super 이랑 같음
        // 지글 오버라이드 했고 실제 구현체라고 생각하면 됨 config에서 호출도 이거 핸들러로 했고

        // 다 생각하지 말고 이거 클래스 상속 생각하사함 자식은 부모 클래스꺼 오버라이드 하지 않으면 자식 클래스에서 다 쓸수 있지 않냐 그거임 지금 부모 메서드 사용하 것임

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if(savedRequest!=null) {
            String targetUrl = savedRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request, response, targetUrl);
        } else {
            redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl());
        }
    }

}