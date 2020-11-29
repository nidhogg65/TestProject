package com.nidhogg.studyspringproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Clock;

@Configuration
public class StudyProjectConfig {

    @Bean
    public PasswordEncoder bcryptEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

}
