package pco.aperofriends.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pco.aperofriends.model.Bucket;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Integer>{
	
	@Query("SELECT b FROM Bucket b WHERE b.friend LIKE ?1")	
	public List<Bucket> findByIdFriend(Integer idFriend);

	@Transactional
	@Modifying
	@Query(value="INSERT into bucket_items(id_bucket, id_item) VALUES(?1, ?2)", nativeQuery=true)
	public void addItem(Integer idBucket, Integer idItem);

	@Transactional
	@Modifying
	@Query(value="DELETE FROM bucket WHERE id_bucket = ?1 AND id_item = ?2", nativeQuery=true)
	public void deleteItem(Integer idBucket, Integer idItem);

	@Transactional
	@Modifying
	@Query(value="UPDATE bucket SET statut='PANIER_FINALISE' WHERE id = ?1", nativeQuery=true)
	public void finalBucket(Integer idBucket);

}
