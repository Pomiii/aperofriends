package pco.aperofriends.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pco.aperofriends.model.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{
	
	@Query("SELECT f FROM Friend f WHERE f.firstnameFriend LIKE ?1")
	public Friend findByFirstnameFriend(String friend);
	
	Optional<Friend> findByMailFriend(String mailFriend);

    boolean existsByMailFriend(String mailFriend);

    void deleteByMailFriend(String mailFriend);
}
