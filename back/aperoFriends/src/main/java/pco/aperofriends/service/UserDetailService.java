package pco.aperofriends.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pco.aperofriends.model.Friend;
import pco.aperofriends.repository.FriendRepository;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public UserDetails loadUserByUsername(String mailFriend) throws UsernameNotFoundException {
        final Friend friend = friendRepository.findByMailFriend(mailFriend);

        if (friend == null) {
            throw new UsernameNotFoundException("MailFriend '" + mailFriend + "' not found");
        }

        return User
                .withUsername(mailFriend)
                .password(friend.getPassFriend())
                .authorities(friend.getRole().getRole())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}

