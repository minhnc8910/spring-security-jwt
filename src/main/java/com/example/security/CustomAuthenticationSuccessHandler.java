//package com.example.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        System.out.println(11111);
//        Map<String,Object> body = new LinkedHashMap<>();
//        body.put("status","345");
//        body.put("message","successfully");
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        OutputStream out = response.getOutputStream();
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writerWithDefaultPrettyPrinter().writeValue(out, response);
//        out.flush();
//
//    }
//}
