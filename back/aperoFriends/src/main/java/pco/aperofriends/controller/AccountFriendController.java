package pco.aperofriends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pco.aperofriends.model.AccountFriend;
import pco.aperofriends.repository.AccountFriendRepository;
import pco.aperofriends.service.AccountFriendService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AccountFriendController {
	
	@Autowired
	AccountFriendRepository accountFriendRepository;
	
	private AccountFriendService accountFriendService;
	
	public AccountFriendController(AccountFriendService accountFriendService) {
		this.accountFriendService = accountFriendService;
	}

	/**
	 * Methode qui renvois l'ensemble des éléments de la table friend
	 * 
	 * @param model
	 * @return friend
	 */
	@GetMapping("/accountFriends")
	public ResponseEntity<?> accountFriends() {
		List<AccountFriend> accountFriends = accountFriendRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(accountFriends);// retourne la page friends
	}
	
	/**
	 * Methode qui permet d'ajouter un friend dans la table friend
	 * @param request
	 * @return createfriend
	 */
	@PostMapping("/createAccountFriend/{nameAccount}/{addressAccount}/{phoneAccount}")
	// @PreAuthorize("hasRole('ADMIN') OR hasRole('GESTIONNAIRE')")
		public ResponseEntity<?> createAccountFriend(
				@PathVariable String addressAccount,
				@PathVariable String nameAccount,
				@PathVariable String phoneAccount
				) {
			try {
				return ResponseEntity.status(HttpStatus.OK)
	                .body(this.accountFriendService.saveAccountFriend(nameAccount, addressAccount, phoneAccount));
			} catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		    }
			
		}
	
	/**
	 * Methode qui renvois l'ensemble des éléments de la table friend
	 * @param request
	 * @param model
	 * @return updateFriend
	 */
	@PutMapping("/updateAccountFriend")
	// @PreAuthorize("hasRole('ADMIN') OR hasRole('GESTIONNAIRE')")
	public ResponseEntity<?> updateAccountFriend(@RequestBody AccountFriend accountFriend) {

		AccountFriend updateAccountFriend = accountFriendRepository.save(accountFriend);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateAccountFriend);
	}

	/**
	 * 
	 * @param idAF
	 * @return accountFriend
	 */
	@DeleteMapping("/deleteAccountFriend/{idAF}")
	public ResponseEntity<?> deleteAccountFriend(@PathVariable Integer idAF) {
		try {
			accountFriendRepository.deleteById(idAF);
			return ResponseEntity.status(HttpStatus.OK)
	                .body(null);
		} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
