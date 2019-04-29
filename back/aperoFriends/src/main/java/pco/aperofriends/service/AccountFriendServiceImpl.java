package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import pco.aperofriends.model.AccountFriend;
import pco.aperofriends.repository.AccountFriendRepository;

public class AccountFriendServiceImpl implements AccountFriendService {
	
	private AccountFriendRepository accountFriendRepository;
	
	public AccountFriendServiceImpl(AccountFriendRepository accountFriendRepository) {
		this.accountFriendRepository = accountFriendRepository;
	}
	
	@Override
	public List<AccountFriend> findAllAccountFriends(){
		return accountFriendRepository.findAll();
	}
	
	@Override
	public Optional<AccountFriend> findFriendByIdAccountFriend(Integer idAccountFriend) {
		return accountFriendRepository.findById(idAccountFriend);
	}
	
	@Override
    public AccountFriend createAccountFriend(AccountFriend newfriend) {
        return accountFriendRepository.save(newfriend);
    }
	
	@Override
    public AccountFriend saveAccountFriend(AccountFriend accountFriend) {
        return accountFriendRepository.save(accountFriend);
    }

}
