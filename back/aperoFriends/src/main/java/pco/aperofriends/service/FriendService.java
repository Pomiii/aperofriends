package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.model.Friend;

@Service
public interface FriendService {
	
	List<Friend> findAllFriends();
	
	Optional<Friend> findFriendByIdFriend(Integer idFriend);
	
	Friend createFriend(Friend newfriend);
	
	Friend saveFriend(String firstnameFriend,
					  String lastnameFriend,
					  String mailFriend,
					  String passFriend);
}
