package pco.aperofriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pco.aperofriends.model.TypeItem;

@Repository
public interface TypeItemRepository extends JpaRepository<TypeItem, Integer> {
	
	@Query("SELECT t FROM TypeItem t WHERE t.nameTypeItem LIKE ?1")
	public TypeItem findByType(String typeItem);

}
