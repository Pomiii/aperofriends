package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.model.AccountFriend;
import pco.aperofriends.repository.AccountFriendRepository;

@Service
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
    public AccountFriend saveAccountFriend(String addressAccount,
										   String nameAccount,
										   String phoneAccount) {
		AccountFriend accountFriend = new AccountFriend(addressAccount, nameAccount, phoneAccount);
		return this.accountFriendRepository.save(accountFriend);    
	}

}
