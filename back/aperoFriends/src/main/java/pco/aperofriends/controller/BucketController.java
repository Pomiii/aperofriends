package pco.aperofriends.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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

import pco.aperofriends.model.Bucket;
import pco.aperofriends.model.Friend;
import pco.aperofriends.model.Item;
import pco.aperofriends.repository.BucketRepository;
import pco.aperofriends.repository.FriendRepository;
import pco.aperofriends.repository.ItemRepository;
import pco.aperofriends.service.BucketService;
import pco.aperofriends.service.FriendService;

@RestController
@CrossOrigin("http://localhost:4200")
public class BucketController {
	@Autowired
	BucketRepository bucketRepository;
	
	@Autowired
	FriendRepository friendRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	private BucketService bucketService;
	private FriendService friendService;

	
	public BucketController( BucketService bucketService,
							 FriendService friendService) {
		this.bucketService = bucketService;
		this.friendService = friendService;
	}

	/**
	 * Methode qui renvois l'ensemble des éléments de la table friend
	 * @param model
	 * @return buckets
	 */
	@GetMapping("/buckets")
	public ResponseEntity<?> buckets() {
		List<Bucket> buckets = bucketRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(buckets);
	}
	
	// @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/bucket/{idBucket}")
	public ResponseEntity<?> getOneBucket(@PathVariable Integer idBucket) {
		Optional<Bucket> bucketId = bucketRepository.findById(idBucket);
		return ResponseEntity.status(HttpStatus.OK).body(bucketId);
	}
	
	@PostMapping("/addBucket/{mailFriend}")
	public ResponseEntity<Bucket> addBucket(@PathVariable String mailFriend) {
		Logger logger = Logger.getLogger("addBucket Try-Catch Erreur");	
		try {
			Friend friend = this.friendService.findFriendByMailFriend(mailFriend);
			System.out.println("---------- BUCKET idFriend --------- " + friend.getIdFriend());
			return ResponseEntity.status(HttpStatus.OK).body(this.bucketService.saveBucket(new Bucket(friend, new Date())));
		} catch(Exception e) {
			logger.log(Level.SEVERE,e.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Methode qui renvoie l'ensemble des éléments de la table friend
	 * @param request
	 * @param model
	 * @return updateFriend
	 */
	@PutMapping("/updateBucket/{idFriend}")
	// @PreAuthorize("hasRole('ADMIN') OR hasRole('GESTIONNAIRE')")
	public ResponseEntity<?> updateBucket(@RequestBody Item[] items,
										  @PathVariable int idFriend) {
		Friend friend = this.friendRepository.findById(idFriend).get();
		List<Item> addItem = new ArrayList<Item>();
		System.out.println("-------------------- friend Name ----------------" + friend.getFirstnameFriend());
		System.out.println("-------------------- item.length ----------------" + items.length);
		for (Item i : items) { 
			addItem.add(i);
		}
		Bucket bucket = new Bucket(friend, addItem);
		return ResponseEntity.status(HttpStatus.OK).body(this.bucketRepository.save(bucket));
	}

	/**
	 * 
	 * @param idBucket
	 * @return bucket
	 */
	@DeleteMapping("/deleteBucket/{idBucket}")
	//@PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> deleteBucket(@PathVariable Integer idBucket) {
		try {
			bucketRepository.deleteById(idBucket);
			return ResponseEntity.status(HttpStatus.OK)
	                .body(null);
		} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/addItemToBucket/{idItem}")
	public ResponseEntity<?> addItemToBucket(@PathVariable Integer idBucket,
											 @PathVariable Integer idItem){
		try {
			itemRepository.findById(idItem);
			bucketRepository.findById(idBucket);
			return ResponseEntity.status(HttpStatus.OK).body(this.bucketService.saveBucket(new Bucket(new Friend(), new Date())));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}

