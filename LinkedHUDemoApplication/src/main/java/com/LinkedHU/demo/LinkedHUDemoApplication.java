package com.LinkedHU.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.LinkedHU")
public class LinkedHUDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedHUDemoApplication.class, args);
	}

}
