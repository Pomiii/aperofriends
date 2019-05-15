package pco.aperofriends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pco.aperofriends.model.Friend;
import pco.aperofriends.repository.FriendRepository;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public UserDetails loadUserByUsername(String mailFriend) throws UsernameNotFoundException {
        final Optional<Friend> friend = friendRepository.findByMailFriend(mailFriend);

        if (!friend.isPresent()) {
            throw new UsernameNotFoundException("Friend '" + mailFriend + "' not found");
        }

        return User
                .withUsername(mailFriend)
                .password(friend.get().getPassFriend())
                .authorities(friend.get().getRoleList())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
