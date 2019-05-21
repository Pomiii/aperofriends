package pco.aperofriends.controller;

import java.util.List;
import java.util.Optional;

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
import pco.aperofriends.repository.BucketRepository;
import pco.aperofriends.service.BucketService;

@RestController
@CrossOrigin("http://localhost:4200")
public class BucketController {
	@Autowired
	BucketRepository bucketRepository;
	
	private BucketService bucketService;
	
	public BucketController( BucketService bucketService) {
		this.bucketService = bucketService;
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
	
	/**
	 * Methode qui permet d'ajouter un friend dans la table friend
	 * @param request
	 * @return createfriend
	 */
	@PostMapping("/createBucket")
	// @PreAuthorize("hasRole('ADMIN') OR hasRole('GESTIONNAIRE')")
	public ResponseEntity<?> createBucket() {
		try {
			return ResponseEntity.status(HttpStatus.OK)
                .body(this.bucketService.saveBucket());
		} catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
	
	/**
	 * Methode qui renvoie l'ensemble des éléments de la table friend
	 * @param request
	 * @param model
	 * @return updateFriend
	 */
	@PutMapping("/updateBucket")
	// @PreAuthorize("hasRole('ADMIN') OR hasRole('GESTIONNAIRE')")
	public ResponseEntity<?> updateBucket(@RequestBody Bucket bucket) {
		Bucket updateBucket = bucketRepository.save(bucket);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateBucket);
	}

	/**
	 * 
	 * @param idFriend
	 * @return friend
	 */
	@DeleteMapping("/deleteBucket/{idBucket}")
	public ResponseEntity<?> deleteBucket(@PathVariable Integer idBucket) {
		try {
			bucketRepository.deleteById(idBucket);
			return ResponseEntity.status(HttpStatus.OK)
	                .body(null);
		} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}

