package com.luv2code.springboot.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach coach;

    // define constructor for dependency injection
    public DemoController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getdailyworkout")
    String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
