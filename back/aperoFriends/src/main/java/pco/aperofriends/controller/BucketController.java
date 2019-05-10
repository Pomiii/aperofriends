package pco.aperofriends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pco.aperofriends.model.Bucket;
import pco.aperofriends.repository.BucketRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class BucketController {
	@Autowired
	BucketRepository bucketRepository;
	
	@GetMapping("/buckets")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getBucketByFriend(@RequestParam(name="id_friend" ,required=true)  Integer id_friend){
		List<Bucket> buckets = bucketRepository.findByIdFriend(id_friend);
		
		return ResponseEntity.status(HttpStatus.OK).body(buckets);
	}
	
	@PostMapping("/createBucket")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> createBucket(@RequestBody Bucket bucket){
		Bucket createBucket = bucketRepository.save(bucket);
		return ResponseEntity.status(HttpStatus.CREATED).body(createBucket); 
	}
	
/*	@PostMapping("/addItemBucket")
	//@PreAuthorize("hasRole('USER')")
	public void addItemBucket(@RequestParam(name="idBucket") Integer idBucket, @RequestParam(name="idItem") Integer idItem){
		bucketRepository.addItem(idBucket, idItem);
	}
	
	@DeleteMapping("/deleteItemeBucket")
	//@PreAuthorize("hasRole('USER')")
	public void deleteItemeBucket(@RequestParam(name="idBucket") Integer idBucket, @RequestParam(name="idItem") Integer idItem){
		bucketRepository.deleteItem(idBucket, idItem);
	}
	
	@PostMapping("/finalBucket")
	//@PreAuthorize("hasRole('USER')")
	public void finalBucket(@RequestParam(name="idBucket") Integer idBucket){
		bucketRepository.finalBucket(idBucket);
	}
*/	
	@DeleteMapping("/deleteBucket")
	//@PreAuthorize("hasRole('USER')")
	public void deleteItem(@RequestParam(name="bucketId", required=true) Integer bucketId) {
		bucketRepository.deleteById(bucketId);
	}

}
