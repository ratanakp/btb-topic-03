package com.example.demotopic03.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomAuthenticationEntryPoint  implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e)
            throws IOException, ServletException {

        System.out.println("Login required!!!");


//        System.out.println(httpServletRequest.getRequestURI());
//        System.out.println(httpServletRequest.getRequestURL());

        String requestURI = httpServletRequest.getRequestURI();

        httpServletRequest.getSession().setAttribute("EHAN_REDIRECT_URI", requestURI);

        httpServletResponse.sendRedirect("/login");

    }
}
