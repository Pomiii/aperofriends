package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.model.Friend;
import pco.aperofriends.repository.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService {

	private FriendRepository friendRepository;
	
	public FriendServiceImpl(FriendRepository friendRepository) {
		this.friendRepository = friendRepository;
	}
	
	@Override
	public List<Friend> findAllFriends(){
		return friendRepository.findAll();
	}
	
	@Override
	public Optional<Friend> findFriendByIdFriend(Integer idFriend) {
		return friendRepository.findById(idFriend);
	}
	
	@Override
    public Friend createFriend(Friend newfriend) {
		System.out.println("newFriend -- " + newfriend.getFirstnameFriend());
        return friendRepository.save(newfriend);
    }
	
	@Override
    public Friend saveFriend(String firstnameFriend,
    						 String lastnameFriend,
    						 String mailFriend,
    						 String passFriend) {
		Friend friend = new Friend(firstnameFriend, lastnameFriend, mailFriend, passFriend);
		return this.friendRepository.save(friend);
    }
	
}
