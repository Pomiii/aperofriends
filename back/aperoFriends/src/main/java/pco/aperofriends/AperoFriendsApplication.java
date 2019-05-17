package pco.aperofriends;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AperoFriendsApplication implements CommandLineRunner {
/*	
	@Resource
	  StorageService storageService;
	  
	  @Override
	public void run(String... arg) throws Exception {
	   // storageService.init();
	}
*/	
	public static void main(String[] args) {
        SpringApplication.run(AperoFriendsApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	 
	
}