package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import pco.aperofriends.model.AccountFriend;

public interface AccountFriendService {
	
	List<AccountFriend> findAllAccountFriends();
	
	Optional<AccountFriend> findFriendByIdAccountFriend(Integer idAccountFriend);
	
	AccountFriend createAccountFriend(AccountFriend newAccountFriend);
	
	AccountFriend saveAccountFriend(String addressAccount,
									String nameAccount,
									String phoneAccount);
	
}
