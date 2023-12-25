package com.example.api.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.api.API.Entity.Item;
import com.example.api.API.Repository.ItemRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	  @Autowired
	  ItemRepository itemRepository;

	  @Override
	  public void run(String... args) throws Exception {
	    itemRepository.save(new Item(null, "Item 1", 1200.00));
	    itemRepository.save(new Item(null, "Item 2", 1500.00));
	  }
}
