//package com.codecool.login;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.springframework.http.HttpStatus.OK;
//
//@Controller
//@CrossOrigin(origins = "http://locahost:3000", allowCredentials = "true")
//@RestController
//@RequestMapping("/login")
//public class LoginController {
//
//    private String SECRET_KEY = "secret";
//
//    @PostMapping()
//    @ResponseBody
//    @ResponseStatus(OK)
//    public String authenticate(@RequestBody LoginCredential loginCredential, HttpServletResponse response) {
//
//        long currentTimeMillisdate = System.currentTimeMillis();
//
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("email", loginCredential.getEmail());
//        String token = Jwts.builder()
//                .setClaims(claims)
//                .setSubject(loginCredential.getEmail())
//                .setIssuedAt(new Date(currentTimeMillisdate))
//                .setExpiration(new Date(currentTimeMillisdate + 1000000000))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//
//        Cookie cookie = new Cookie("Authorization", token);
//        cookie.setMaxAge(7 * 24 * 60 * 60);
//        cookie.setHttpOnly(true);
//        response.addCookie(cookie);
//        response.setHeader("Authorization", token);
//        return token;
//    }
//}
