package pco.aperofriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pco.aperofriends.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	@Query("SELECT i FROM Item i WHERE i.nameItem LIKE ?1")
	public Item findByNameItem(String item);

}
