 package pco.aperofriends.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pco.aperofriends.model.TypeItem;
import pco.aperofriends.repository.TypeItemRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class TypeItemController {
	
	@Autowired
	TypeItemRepository typeItemRepository;

	@GetMapping("/typeItems")
	public ResponseEntity<?> typeItems() {
		List<TypeItem> typeItems = typeItemRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(typeItems);
	}

	@GetMapping("/typeItem/{idTypeItem}")
	public ResponseEntity<?> getOnetypeItem(@PathVariable Integer idTypeItem) {
		Optional<TypeItem> typeItem = typeItemRepository.findById(idTypeItem);
		return ResponseEntity.status(HttpStatus.OK).body(typeItem);
	}

}
