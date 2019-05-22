package pco.aperofriends.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pco.aperofriends.dto.FriendDto;
import pco.aperofriends.dto.JsonWebToken;
import pco.aperofriends.exception.ExistingUsernameException;
import pco.aperofriends.exception.InvalidCredentialsException;
import pco.aperofriends.model.Friend;
import pco.aperofriends.repository.FriendRepository;
import pco.aperofriends.service.FriendService;

@RestController
@CrossOrigin("http://localhost:4200")
public class FriendController {

	@Autowired
	FriendRepository friendRepository;
	
	private FriendService friendService;
	
	public FriendController( FriendService friendService) {
		this.friendService = friendService;
	}

	/**
	 * Methode qui renvois l'ensemble des éléments de la table friend
	 * @param model
	 * @return friends
	 */
	@GetMapping("/friends")
	public ResponseEntity<?> friends() {
		List<Friend> friends = friendRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(friends);// retourne la page friends
	}
	

	@PreAuthorize("hasRole('admin')")
	@GetMapping("/friend/{idFriend}")
	public ResponseEntity<?> getOnefriend(@PathVariable Integer idFriend) {
		Optional<Friend> friendId = friendRepository.findById(idFriend);
		return ResponseEntity.status(HttpStatus.OK).body(friendId);
	}
	
	/*
	 * Methode qui permet d'ajouter un friend dans la table friend
	 * @param request
	 * @return createfriend
	 
	@PostMapping("/createFriend/{firstnameFriend}/{lastnameFriend}/{mailFriend}/{passFriend}")
	// @PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> createFriend(
			@PathVariable String firstnameFriend,
			@PathVariable String lastnameFriend,
			@PathVariable String mailFriend,
			@PathVariable String passFriend
			) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
                .body(this.friendService.saveFriend(firstnameFriend, lastnameFriend, mailFriend, passFriend));
		} catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}*/
	
	/**
	 * Methode qui renvoie l'ensemble des éléments de la table friend
	 * @param request
	 * @param model
	 * @return updateFriend
	 */
	@PutMapping("/updateFriend")
	@PreAuthorize("hasRole('admin') OR hasRole('friend')")
	public ResponseEntity<?> updateFriend(@RequestBody Friend friend) {
		Friend updateFriend = friendRepository.save(friend);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateFriend);
	}

	/**
	 * 
	 * @param idFriend
	 * @return friend
	 */
	@DeleteMapping("/deleteFriend/{idFriend}")
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> deleteFriend(@PathVariable Integer idFriend) {
		try {
			friendRepository.deleteById(idFriend);
			return ResponseEntity.status(HttpStatus.OK)
	                .body(null);
		} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	 /**
     * Method to register a new user in database.
     * @param friend the new user to create.
     * @return a JWT if sign up is ok, a bad response code otherwise.
     */
    @PostMapping("/sign-up")
    public ResponseEntity<JsonWebToken> signUp(@RequestBody Friend friend) {
        try {
        	System.out.println("-------- SignUp --------");
            return ResponseEntity.ok(new JsonWebToken(friendService.signUp(friend)));
        } catch (ExistingUsernameException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Method to sign in a user (already existing).
     * @param friend the user to sign in to the app.
     * @return a JWT if sign in is ok, a bad response code otherwise.
     */
    @PostMapping("/sign-in")
    public ResponseEntity<JsonWebToken> signIn(@RequestBody Friend friend) {
        try {
            return ResponseEntity.ok(new JsonWebToken(friendService.signIn(friend.getMailFriend(), friend.getPassFriend())));
        } catch (InvalidCredentialsException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Method to get all users from the database.
     * This method is restricted to Admin users.
     * @return the list of all users registered in the database.
     */
    @GetMapping("/testpost")
    @PreAuthorize("hasAuthority('friend')")
    public List<FriendDto> getAllFriends() {
        return friendService.findAllFriends().stream().map(friend -> new FriendDto(friend.getMailFriend(), friend.getRole())).collect(Collectors.toList());
    }

    /*
     * Method to get one user from database based on its user name.
     * This method is restricted to Admin users.
     * @param mailFriend the user name to look for.
     * @return a User object if found, a not found response code otherwise.
     
    @GetMapping("/{mailFriend}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<FriendDto> getOneUser(@PathVariable String mailFriend) {
        Friend friend = friendService.findFriendByMailFriend(mailFriend);
        if (friend == null) {
            return ResponseEntity.ok(new FriendDto(friend.get().getMailFriend(), friend.get().getRole()));
        } else {
            return ResponseEntity.notFound().build();
        }
	
    }*/
}