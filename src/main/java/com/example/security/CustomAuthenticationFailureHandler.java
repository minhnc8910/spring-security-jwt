//package com.example.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        Map<String,Object> body = new LinkedHashMap<>();
//        body.put("status","345678");
//        body.put("message","unauthorized access");
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        OutputStream out = response.getOutputStream();
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writerWithDefaultPrettyPrinter().writeValue(out, response);
//        out.flush();
//    }
//}
