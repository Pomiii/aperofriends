package pco.aperofriends.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/typeItems/{id}")
	public ResponseEntity<?> typeItem(@PathVariable Integer idTypeItem) {
		Optional<TypeItem> typeItems = typeItemRepository.findById(idTypeItem);

		return ResponseEntity.status(HttpStatus.OK).body(typeItems);
	}

	@PostMapping("/addTypeItem")
	// @PreAuthorize("hasRole('ADMIN') OR hasRole('GESTIONNAIRE')")
	public ResponseEntity<?> ajoutTypeItems(@RequestBody TypeItem typeItem) {
		TypeItem typeItems = typeItemRepository.save(typeItem);

		return ResponseEntity.status(HttpStatus.OK).body(typeItems);
	}

	@PostMapping("/updateTypeItem")
	// @PreAuthorize("hasRole('ADMIN') OR hasRole('GESTIONNAIRE')")
	public ResponseEntity<?> updateTypeItem(@RequestBody TypeItem typeItem) {
		TypeItem updateTypeItem = typeItemRepository.save(typeItem);

		return ResponseEntity.status(HttpStatus.CREATED).body(updateTypeItem);
	}

	@DeleteMapping("/deleteTypeItem/{id}")
	// @PreAuthorize("hasRole('ADMIN') OR hasRole('GESTIONNAIRE')")
	public ResponseEntity<?> deleteTypeItem(@PathVariable Integer idTypeItem) {
		typeItemRepository.deleteById(idTypeItem);

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
