package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.exception.ExistingMailFriendException;
import pco.aperofriends.exception.InvalidCredentialsException;
import pco.aperofriends.model.Friend;
import pco.aperofriends.model.Role;

@Service
public interface FriendService {
	
	List<Friend> findAllFriends();
	
	Optional<Friend> findFriendByIdFriend(Integer idFriend);
	
	Friend createFriend(Friend newfriend);
	
	Friend saveFriend(String firstnameFriend,
					  String lastnameFriend,
					  String mailFriend,
					  String passFriend,
					  List<Role> roleList);
	/**
     * Method that signs a user in the application.
     * @param mailFriend the user mailFriend.
     * @param passFriend the user password.
     * @return the JWT if credentials are valid, throws InvalidCredentialsException otherwise.
     * @throws InvalidCredentialsException
     */
    String signIn(String mailFriend, String passFriend) throws InvalidCredentialsException;

    /**
     * Method that signs up a new user in the application.
     * @param friend the new user to create.
     * @return the JWT if user mailFriend is not already existing.
     * @throws ExistingUsernameException
     */
    String signUp(Friend friend) throws ExistingMailFriendException;
    
    /**
     * Method that finds a user based on its userName.
     * @param mailFriend the userName to look for.
     * @return an Optional object containing user if found, empty otherwise.
     */
    Optional<Friend> findFriendByMailFriend(String mailFriend);
}
