package pco.aperofriends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pco.aperofriends.model.Item;
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
        return itemRepository.save(newItem);
    }
	
	@Override
    public Item saveItem(String nameItem,
			int priceItem,
			String picItem,
			String typeItem) {
		String itemType = this.typeItemRepository.findByType(typeItem).getNameTypeItem();
		if (itemType != null) {
		Item item = new Item(nameItem, priceItem, picItem, this.typeItemRepository.findByType(typeItem));
		return this.itemRepository.save(item);
		} else return null;
		
    }
}
