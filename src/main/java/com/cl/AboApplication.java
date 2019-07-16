package com.cl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cl")
public class AboApplication {

	public static void main(String[] args) {
		SpringApplication.run(AboApplication.class, args);
	}

}
