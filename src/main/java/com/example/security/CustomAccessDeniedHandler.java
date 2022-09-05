package com.example.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Map<String,Object> body = new LinkedHashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        body.put("Timestamp", LocalDateTime.now().toString());
        body.put("Status", HttpServletResponse.SC_FORBIDDEN);
        body.put("Errors", accessDeniedException.getMessage());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        OutputStream out = response.getOutputStream();
        mapper.writerWithDefaultPrettyPrinter().writeValue(out,body);
        mapper.writeValue(out, body);
        out.flush();
    }
}
