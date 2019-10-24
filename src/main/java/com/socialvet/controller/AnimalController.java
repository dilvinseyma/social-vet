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

import com.fasterxml.jackson.databind.JsonNode;
import com.socialvet.model.Animal;
import com.socialvet.repository.AnimalRepository;

@RestController
@CrossOrigin(origins = "*")
public class AnimalController {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@RequestMapping(value = "/animals", method = RequestMethod.GET)
	public ResponseEntity<List<Animal>> getAnimals() {
		return new ResponseEntity<>((List<Animal>) animalRepository.findAll(), HttpStatus.OK);
	}

	// also used for update, when id present in request
	@RequestMapping(value = "/saveanimal", method = RequestMethod.POST)
	public ResponseEntity<Animal> saveAnimal(@RequestBody Animal requestAnimal){
		
		return new ResponseEntity<>(animalRepository.save(requestAnimal), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteanimal", method = RequestMethod.POST)
	public ResponseEntity<?> deleteAnimal(@RequestParam Long id){
		
		Optional<Animal> animalToDelete = animalRepository.findById(id);
		
		if(animalToDelete.isPresent()) {
			Animal animal = animalToDelete.get();
			animal.setStatus(false);
			animalRepository.save(animal);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(value = "/searchbyanimalname", method = RequestMethod.POST)
	public ResponseEntity<List<Animal>> searchByName(@RequestBody JsonNode request){
		String animalName = request.findValue("animalName").asText();
		return new ResponseEntity<>(animalRepository.findAnimalsByName(animalName), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchbypetsitterusername", method = RequestMethod.POST)
	public ResponseEntity<List<Animal>> searchByPetSitterName(@RequestBody JsonNode request){
		String username = request.findValue("username").asText();
		return new ResponseEntity<>(animalRepository.findAnimalsByPetSitterUsername(username), HttpStatus.OK);
	}
}

