package com.codecool.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final int expirationTime;
    private final String secret;
    private final Logger logger;

    public AuthenticationSuccessHandler(@Value("${jwt.expirationTime}") int expirationTime,
                                            @Value("${jwt.secret}") String secret) {
        this.expirationTime = expirationTime;
        this.secret = secret;
        this.logger = LoggerFactory.getLogger(CORSFilter.class);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                          Authentication authentication){
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String token = createToken(principal);

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        setHeader(request, response, token);
        response.addCookie(cookie);
    }

    private String createToken(UserDetails principal) {
        long actualTime = System.currentTimeMillis();
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withIssuedAt(new Date(actualTime))
                .withExpiresAt(new Date(actualTime + expirationTime))
                .sign(Algorithm.HMAC256(secret));

        return token;
    }

    private void setHeader(HttpServletRequest request, HttpServletResponse response, String token){
        response.addHeader("Authorization", "Bearer " + token);
//        response.addHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

    }
}
