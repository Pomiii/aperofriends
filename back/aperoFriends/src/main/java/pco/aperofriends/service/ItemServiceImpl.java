package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.model.Item;
import pco.aperofriends.model.TypeItem;
import pco.aperofriends.repository.ItemRepository;
import pco.aperofriends.repository.TypeItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;
	
	private TypeItemRepository typeItemRepository;
	
	public ItemServiceImpl(ItemRepository itemRepository,
							TypeItemRepository typeItemRepository) {
		this.itemRepository = itemRepository;
		this.typeItemRepository = typeItemRepository;
	}
	
	@Override
	public List<Item> findAllItems(){
		return itemRepository.findAll();
	}
	
	@Override
	public Optional<Item> findFriendByIdItem(Integer idItem) {
		return itemRepository.findById(idItem);
	}
	
	@Override
    public Item createItem(Item newItem) {
        return itemRepository.save(new Item("Pom",
        									"Pom",
        									this.typeItemRepository.findByType("alccol"),
        									1));
    
    }
	
	@Override
	public Item saveItem(Item item, TypeItem typeItem) {		
		Item newItem = this.itemRepository.save(new Item(item.getNameItem(), item.getPicItem(), item.getPriceItem()));
		newItem.setTypeItem(typeItem);
		return this.itemRepository.save(newItem);
	}
}
