package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.model.Item;

@Service
public interface ItemService {
	
	List<Item> findAllItems();
	
	Optional<Item> findFriendByIdItem(Integer idItem);
	
	Item createItem(Item newItem);
	
	Item saveItem(String nameItem,
			int priceItem,
			String picItem,
			String typeItem);
}
