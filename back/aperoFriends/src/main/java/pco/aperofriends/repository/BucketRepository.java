package pco.aperofriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pco.aperofriends.model.Bucket;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Integer>{
	
<<<<<<< HEAD
	@Query("SELECT b FROM Bucket b WHERE b.accountFriend LIKE ?1")	
	public List<Bucket> findByIdFriend(Integer idFriend);
=======
/*@Query("SELECT b FROM Bucket b WHERE b.account_friend LIKE ?1")	
	public List<Bucket> findByIdAF(BucketPK bucketPK);
>>>>>>> origin

	@Transactional
	@Modifying
	@Query(value="INSERT into bucket (id_af, id_item) VALUES(?1, ?2)", nativeQuery=true)
	public void addItem(BucketPK bucketPK, Integer idItem);

	@Transactional
	@Modifying
	@Query(value="DELETE FROM bucket WHERE id = ?1 AND id_item = ?2", nativeQuery=true)
	public void deleteItem(BucketPK bucketPK, Integer idItem);

	@Transactional
	@Modifying
	@Query(value="UPDATE bucket SET statut='PANIER_FINALISE' WHERE id = ?1", nativeQuery=true)
	public void finalBucket(BucketPK bucketPK);

}*/
}