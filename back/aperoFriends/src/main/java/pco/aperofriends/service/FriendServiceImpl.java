package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pco.aperofriends.exception.ExistingUsernameException;
import pco.aperofriends.exception.InvalidCredentialsException;
import pco.aperofriends.model.Friend;
import pco.aperofriends.repository.FriendRepository;
import pco.aperofriends.repository.RoleRepository;
import pco.aperofriends.security.JwtTokenProvider;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendRepository friendRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private BCryptPasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private AuthenticationManager authenticationManager;
	
	public FriendServiceImpl(FriendRepository friendRepository,
							 RoleRepository roleRepository,
							 BCryptPasswordEncoder passwordEncoder,
							 JwtTokenProvider jwtTokenProvider, 
							 AuthenticationManager authenticationManager) {
		this.friendRepository = friendRepository;
		this.roleRepository = roleRepository;
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
    public Friend findFriendByMailFriend(String mailFriend) {
        return friendRepository.findByMailFriend(mailFriend);
    }
	
	/*@Override
    public Friend createFriend(Friend newfriend) {
		System.out.println("newFriend -- " + newfriend.getFirstnameFriend());
        return friendRepository.save(newfriend);
    }*/
	
	@Override
    public Friend saveFriend(String firstnameFriend,
    						 String lastnameFriend,
    						 String mailFriend,
    						 String passFriend) {
		Friend friend = new Friend(firstnameFriend, lastnameFriend, mailFriend, passFriend);
		return this.friendRepository.save(friend);
    }
	
	@Override
    public String signIn(String mailFriend, String passFriend) throws InvalidCredentialsException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mailFriend, passFriend));
            return jwtTokenProvider.createToken(mailFriend, friendRepository.findByMailFriend(mailFriend).getRole());
        } catch (AuthenticationException e) {
            throw new InvalidCredentialsException();
        }
    }

    @Override
    public String signUp(Friend friend) throws ExistingUsernameException {
        if (!friendRepository.existsByMailFriend(friend.getMailFriend())) {
        	System.out.println("---------------SignUp Service ------------" + friendRepository.existsByMailFriend(friend.getMailFriend()));
            Friend friendToSave = new Friend(friend.getFirstnameFriend(), 
            								 friend.getLastnameFriend(), 
            								 friend.getMailFriend(), 
            								 passwordEncoder.encode(friend.getPassFriend()));
            
            Friend newFriend = friendRepository.save(friendToSave);
            
            newFriend.setRole(roleRepository.findByRole("friend"));
            friendRepository.save(newFriend);
            
            return jwtTokenProvider.createToken(friend.getMailFriend(), friend.getRole());
        } else {
            throw new ExistingUsernameException();
        }
    }

}
