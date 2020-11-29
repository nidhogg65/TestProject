package com.nidhogg.studyspringproject.common.matcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseBodyMatchers {

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());


    public <T> ResultMatcher containsObjectAsJson(Object expectedObject, Class<T> targetClass) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            T actualObject = objectMapper.readValue(json, targetClass);
            assertThat(actualObject).isEqualToComparingFieldByField(expectedObject);
        };
    }

    public static ResponseBodyMatchers responseBody() {
        return new ResponseBodyMatchers();
    }
}
