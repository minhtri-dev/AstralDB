package com.example.warptracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.warptracker.repository.WarpRepository;
import com.example.warptracker.repository.UserRepository;
import com.example.warptracker.repository.ItemRepository;
import com.example.warptracker.model.warptrackerdb.User;
import com.example.warptracker.model.warptrackerdb.Warp;
import com.example.warptracker.model.warptrackerdb.Item; 

@SpringBootApplication
public class WarptrackerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WarptrackerApplication.class, args);
	}

	@Autowired
	private WarpRepository warpRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository ItemRepository;

	@Override
	public void run(String... args) throws Exception {

		User user = new User(Long.valueOf(1));

		userRepository.save(user);

		System.out.println("User ID: " + user.getUserId());

		Item item = new Item(Long.valueOf(1), "1", "1", 1);

		ItemRepository.save(item);

		Warp warp = new Warp(
			Long.parseLong("1"),
			Long.parseLong("1"), 
			Long.parseLong("1"), 
			Integer.parseInt("1"),
			"1",
			null,
			Timestamp.valueOf("2024-02-10 11:17:15")
		);

		warpRepository.save(warp);

		// Warp warp2 = new Warp(
		// 	Long.parseLong("2"),
		// 	user, 
		// 	Long.parseLong("1"), 
		// 	Integer.parseInt("1"),
		// 	"1",
		// 	null,
		// 	Timestamp.valueOf("2024-02-10 11:17:15")
		// );

		// warpRepository.saveAll(List.of(warp, warp2));

	}	
}
