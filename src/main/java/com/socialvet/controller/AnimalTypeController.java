package com.socialvet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialvet.model.AnimalType;
import com.socialvet.repository.AnimalTypeRepository;

@RestController
@CrossOrigin(origins = "*")
public class AnimalTypeController {

	@Autowired
	private AnimalTypeRepository animalTypeRepository;
	
	@RequestMapping(value = "/animaltypes", method = RequestMethod.GET)
	public ResponseEntity<List<AnimalType>> getAnimalTypes() {

		return new ResponseEntity<>((List<AnimalType>) animalTypeRepository.findAll(), HttpStatus.OK);
				//(List<AnimalType>) animalTypeRepository.findAll();
	}
	
	@RequestMapping(value = "/saveanimaltype", method = RequestMethod.POST)
	public AnimalType saveAnimalType(@RequestBody AnimalType requestAnimalType) {
		return animalTypeRepository.save(requestAnimalType);
	}
	
	@RequestMapping(value = "/deleteanimaltype", method = RequestMethod.POST)
	public ResponseEntity<?> deleteAnimalType(@RequestParam Long id){
		
		Optional<AnimalType> animalType = animalTypeRepository.findById(id);
		return animalType.isPresent() ? 
		  ResponseEntity.ok().build() : ResponseEntity.notFound().build();
		
	}
}
