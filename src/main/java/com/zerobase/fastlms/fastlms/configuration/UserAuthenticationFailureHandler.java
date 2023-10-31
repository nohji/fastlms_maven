package com.zerobase.fastlms.fastlms.configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;

public class UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String msg = "로그인에 실패하였습니다.";
        if(exception instanceof InternalAuthenticationServiceException){
            msg = exception.getMessage();
        }

        setUseForward(true);
      //  setDefaultFailureUrl("/member/login?error=true");
        request.setAttribute("errorMessage", msg);

        System.out.println(msg);

        super.onAuthenticationFailure(request, response, exception);
    }
}
