package com.minhtri.astraldb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;



@SpringBootApplication
public class AstralDBApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AstralDBApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}	
}
