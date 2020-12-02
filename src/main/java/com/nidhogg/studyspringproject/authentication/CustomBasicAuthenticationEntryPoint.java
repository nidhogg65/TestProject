package com.nidhogg.studyspringproject.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nidhogg.studyspringproject.application.dto.error.ApiError;
import com.nidhogg.studyspringproject.application.dto.error.ApiErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    private final ApiErrorFactory errorFactory;
    private final ObjectMapper objectMapper;

    @Autowired
    public CustomBasicAuthenticationEntryPoint(ApiErrorFactory errorFactory, ObjectMapper objectMapper) {
        this.errorFactory = errorFactory;
        this.objectMapper = objectMapper;
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Nidhogg");
        super.afterPropertiesSet();
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.addHeader("Content-Type", "application/json;charset=utf-8");
        response.setStatus(UNAUTHORIZED.value());

        ApiError error = errorFactory.produceApiErrorWithStatusAndMessage(UNAUTHORIZED, authException.getLocalizedMessage());

        PrintWriter writer = response.getWriter();
        writer.println(objectMapper.writeValueAsString(error));
    }
}
