package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.model.Bucket;
import pco.aperofriends.repository.BucketRepository;

@Service
public class BucketServiceImpl implements BucketService{
	
	private BucketRepository bucketRepository;
	
	public BucketServiceImpl(BucketRepository bucketRepository) {
		this.bucketRepository = bucketRepository;
	}
	
	@Override
	public List<Bucket> findAllBuckets(){
		return bucketRepository.findAll();
	}
	
	@Override
	public Optional<Bucket> findBucketByIdBucket(Integer idBucket) {
		return bucketRepository.findById(idBucket);
	}
	
	@Override
    public Bucket createBucket(Bucket newBucket) {
        return bucketRepository.save(newBucket);
    }
	
	@Override
    public Bucket saveBucket(Bucket bucket) {
		return this.bucketRepository.save(bucket);
    }
}
