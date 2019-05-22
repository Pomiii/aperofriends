package pco.aperofriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pco.aperofriends.model.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{
	
	@Query("SELECT f FROM Friend f WHERE f.firstnameFriend LIKE ?1")
	public Friend findByFirstnameFriend(String friend);
	
    boolean existsByMailFriend(String mailFriend);

    void deleteByMailFriend(String mailFriend);
    
	@Query("SELECT f FROM Friend f WHERE f.mailFriend LIKE ?1")
	Friend findByMailFriend(String mailFriend);

}
