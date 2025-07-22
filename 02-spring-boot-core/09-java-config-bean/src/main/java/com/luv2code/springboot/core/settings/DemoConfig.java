package com.luv2code.springboot.core.settings;

import com.luv2code.springboot.core.common.Coach;
import com.luv2code.springboot.core.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
