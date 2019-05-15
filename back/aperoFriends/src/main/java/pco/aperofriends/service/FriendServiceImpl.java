package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pco.aperofriends.exception.ExistingMailFriendException;
import pco.aperofriends.exception.InvalidCredentialsException;
import pco.aperofriends.model.Friend;
import pco.aperofriends.repository.FriendRepository;
import pco.aperofriends.security.JwtTokenProvider;

@Service
public class FriendServiceImpl implements FriendService {

	private FriendRepository friendRepository;
	private BCryptPasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private AuthenticationManager authenticationManager;
	
	public FriendServiceImpl(FriendRepository friendRepository, BCryptPasswordEncoder passwordEncoder,
            JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
		this.friendRepository = friendRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
		this.authenticationManager = authenticationManager;
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
	public String signUp(Friend friend) throws ExistingMailFriendException {
	    if (!friendRepository.existsByMailFriend(friend.getMailFriend())) {
	        Friend friendToSave = new Friend(friend.getFirstnameFriend(),
	        								 friend.getLastnameFriend(),
	        								 friend.getMailFriend(), 
	        								 passwordEncoder.encode(friend.getPassFriend()),
	        								 friend.getRoleList());
	        friendRepository.save(friendToSave);
	        return jwtTokenProvider.createToken(friend.getMailFriend(), friend.getRoleList());
	    } else {
	        throw new ExistingMailFriendException();
	    }
	}

/*	@Override
    public Friend saveFriend(String firstnameFriend,
    						 String lastnameFriend,
    						 String mailFriend,
    						 String passFriend,
    						 List<Role> roleList) {
		Friend friend = new Friend(firstnameFriend, lastnameFriend, mailFriend, passFriend, roleList);
		return this.friendRepository.save(friend);
   }*/

	@Override
	public String signIn(String mailFriend, String passFriend) throws InvalidCredentialsException {
	    try {
	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mailFriend, passFriend));
	        return jwtTokenProvider.createToken(mailFriend, friendRepository.findByMailFriend(mailFriend).get().getRoleList());
	    } catch (AuthenticationException e) {
	        throw new InvalidCredentialsException();
	    }
	}

	@Override
	public Optional<Friend> findFriendByMailFriend(String mailFriend) {
	    return friendRepository.findByMailFriend(mailFriend);
	}
	
}
