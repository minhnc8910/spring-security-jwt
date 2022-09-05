package com.example.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Map<String,Object> body = new LinkedHashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        if (request.getParameter("username")!= null) {
            body.put("Timestamp", LocalDateTime.now().toString());
            body.put("Status", HttpServletResponse.SC_NOT_FOUND);
            body.put("Message", "Username password incorrect");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            OutputStream out = response.getOutputStream();
            mapper.writerWithDefaultPrettyPrinter().writeValue(out, body);
            out.flush();
        } else {
            body.put("Timestamp", LocalDateTime.now().toString());
            body.put("Status", HttpServletResponse.SC_UNAUTHORIZED);
            body.put("Message", "Unauthorized access");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            OutputStream out = response.getOutputStream();
            mapper.writerWithDefaultPrettyPrinter().writeValue(out, body);
            out.flush();
        }
    }
}
