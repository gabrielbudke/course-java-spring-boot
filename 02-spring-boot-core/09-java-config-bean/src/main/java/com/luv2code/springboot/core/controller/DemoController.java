package com.luv2code.springboot.core.controller;

import com.luv2code.springboot.core.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    private final Coach coach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach coach) {
        this.coach = coach;
        System.out.println("In constructor: " + coach.getClass().getSimpleName());
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
