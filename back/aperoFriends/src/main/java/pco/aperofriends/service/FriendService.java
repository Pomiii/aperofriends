package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.exception.ExistingUsernameException;
import pco.aperofriends.exception.InvalidCredentialsException;
import pco.aperofriends.model.Friend;

@Service
public interface FriendService {
	
	List<Friend> findAllFriends();
	
	Optional<Friend> findFriendByIdFriend(Integer idFriend);
	
    Friend findFriendByMailFriend(String mailFriend);
	
	//Friend createFriend(Friend newfriend);
	
	Friend saveFriend(String firstnameFriend,
					  String lastnameFriend,
					  String mailFriend,
					  String passFriend);
	
	 /**
     * Method that signs a user in the application.
     * @param username the user username.
     * @param password the user password.
     * @return the JWT if credentials are valid, throws InvalidCredentialsException otherwise.
     * @throws InvalidCredentialsException
     */
    String signIn(String mailFriend, String passFriend) throws InvalidCredentialsException;

    /**
     * Method that signs up a new user in the application.
     * @param user the new user to create.
     * @return the JWT if user username is not already existing.
     * @throws ExistingUsernameException
     */
    String signUp(Friend friend) throws ExistingUsernameException;


}
