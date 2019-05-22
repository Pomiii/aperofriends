package pco.aperofriends;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pco.aperofriends.service.FriendService;
import pco.aperofriends.service.StorageService;


@SpringBootApplication
public class AperoFriendsApplication implements CommandLineRunner {
	
	@Resource
	  StorageService storageService;
	
	@Autowired
    FriendService friendService;
	
	public static void main(String[] args) {
        SpringApplication.run(AperoFriendsApplication.class, args);
    }

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	 
	@Override
	public void run(String... arg) throws Exception {
		
	}
	 
	 /*
	 * Init method that loads some data in database.
	 * @param params
	 * @throws Exception
	 
	 @Override
	 public void run(String... params) throws Exception {
	        Friend admin = new Friend("pom@test.fr", "123456", new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_FRIEND)));
	        friendService.signup(admin);

	        Friend user = new Friend("lmf@test.com", "azerty", new ArrayList<>(Arrays.asList(Role.ROLE_FRIEND)));
	        friendService.signup(user);

	    }
*/
}