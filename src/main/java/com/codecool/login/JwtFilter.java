//package com.codecool.login;
//
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
//public class JwtFilter implements javax.servlet.Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        Cookie[] cookies = request.getCookies();
//        System.out.println(cookies ==null);
//        final String authorizationHeader = request.getHeader("Authorization");
//        System.out.println(authorizationHeader + "asdsa");
//        filterChain.doFilter(request, response);
//    }
//}
