package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.model.Bucket;

@Service
public interface BucketService {
	
	List<Bucket> findAllBuckets();
		
	Optional<Bucket> findBucketByIdBucket(Integer idBucket);
		
	Bucket createBucket(Bucket newBucket);
		
	Bucket saveBucket(Bucket bucket);
}
