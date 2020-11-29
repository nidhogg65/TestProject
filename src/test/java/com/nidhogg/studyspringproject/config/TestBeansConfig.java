package com.nidhogg.studyspringproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Clock;
import java.time.Instant;

@Configuration
public class TestBeansConfig {

    @Bean
    @Primary
    public Clock testClock() {
        return Clock.fixed(Instant.parse("2020-12-20T10:20:40Z"), Clock.systemDefaultZone().getZone());
    }

}
