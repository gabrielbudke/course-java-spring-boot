package com.luv2code.springboot.core.controller;

import com.luv2code.springboot.core.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;

    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getdailyworkout")
    String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
