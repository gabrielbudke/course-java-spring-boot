package com.luv2code.springboot.core.controller;

import com.luv2code.springboot.core.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("baseballCoach") Coach coach,
            @Qualifier("baseballCoach") Coach anotherCoach) {
        this.coach = coach;
        this.anotherCoach = anotherCoach;
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        System.out.println(coach);
        System.out.println(anotherCoach);
        return "Comparing beans: myCoah == anotherCoach, " + (coach == anotherCoach);
    }

}
