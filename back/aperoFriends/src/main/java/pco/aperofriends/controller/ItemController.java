package pco.aperofriends.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pco.aperofriends.model.Item;
import pco.aperofriends.model.TypeItem;
import pco.aperofriends.repository.BucketRepository;
import pco.aperofriends.repository.ItemRepository;
import pco.aperofriends.repository.TypeItemRepository;
import pco.aperofriends.service.ItemService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	TypeItemRepository typeItemRepository;
	
	@Autowired
	BucketRepository bucketrepository;

	private ItemService itemService;
	
	public ItemController( ItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * Methode qui renvois l'ensemble des éléments de la table item
	 * @param model
	 * @return items
	 */
	@GetMapping("/items")
	public ResponseEntity<?> items() {
		System.out.println("GetMapping items");
		List<Item> items = itemRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(items);// retourne la page item	
	}
	
	@GetMapping("/item/{idItem}")
	public ResponseEntity<?> getOneItem(@PathVariable Integer idItem) {
		Optional<Item> item = itemRepository.findById(idItem);
		return ResponseEntity.status(HttpStatus.OK).body(item);
	}
	
	/**
	 * Methode qui permet d'ajouter un Item dans la table Item
	 * @param request
	 * @return createItem
	 */
	@PostMapping("/createItem/{typeItemString}")
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<?> createItem(@RequestBody Item item, @PathVariable String typeItemString) {
		try {
			TypeItem typeItem = this.typeItemRepository.findByType(typeItemString);
			return ResponseEntity.status(HttpStatus.OK)
               .body(this.itemService.saveItem(item, typeItem));
		} catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }	
	}
	
	/**
	 * Methode qui renvois l'ensemble des éléments de la table Item
	 * @param request
	 * @param model
	 * @return updateItem
	 */
	@PutMapping("/updateItem")
	// @PreAuthorize("hasRole('admin') OR hasRole('GESTIONNAIRE')")
	public ResponseEntity<?> updateItem(@RequestBody Item item) {
		Item updateItem = itemRepository.save(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateItem);
	}

	/**
	 * 
	 * @param idItem
	 * @return item
	 */
	@DeleteMapping("/deleteItem/{idItem}")
	public ResponseEntity<?> deleteFriend(@PathVariable Integer idItem) {
		try {
			itemRepository.deleteById(idItem);
			return ResponseEntity.status(HttpStatus.OK)
	                .body(null);
		} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
