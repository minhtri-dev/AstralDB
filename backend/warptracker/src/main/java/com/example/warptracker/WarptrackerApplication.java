package com.example.warptracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;



@SpringBootApplication
public class WarptrackerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WarptrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}	
}
