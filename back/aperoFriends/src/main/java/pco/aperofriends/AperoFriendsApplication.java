package pco.aperofriends;


import org.springframework.boot.SpringApplication;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pco.aperofriends.service.StorageService;


@SpringBootApplication
public class AperoFriendsApplication implements CommandLineRunner {
	
	@Resource
	  StorageService storageService;
	
	public static void main(String[] args) {
        SpringApplication.run(AperoFriendsApplication.class, args);
    }

	  @Override
	public void run(String... arg) throws Exception {
	   // storageService.init();
	}
	 
	
}