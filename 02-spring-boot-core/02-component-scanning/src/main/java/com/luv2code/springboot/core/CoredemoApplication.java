package com.luv2code.springboot.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.luv2code.springboot.core",
				"com.luv2code.springboot.util"
		}
)
public class CoredemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoredemoApplication.class, args);
	}

}
