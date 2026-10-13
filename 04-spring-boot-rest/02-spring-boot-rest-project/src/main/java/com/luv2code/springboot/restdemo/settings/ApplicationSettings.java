package com.luv2code.springboot.restdemo.settings;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationSettings {

    @Bean
    public JsonMapper getJsonMapper() {
        return new JsonMapper();
    }

}
