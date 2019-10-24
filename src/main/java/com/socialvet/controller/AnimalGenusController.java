package com.socialvet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialvet.model.AnimalGenus;
import com.socialvet.repository.AnimalGenusRepository;

@RestController
public class AnimalGenusController {

	@Autowired
	private AnimalGenusRepository animalGenusRepository;
	
	@RequestMapping(value = "/animalgenuses", method = RequestMethod.GET)
	public ResponseEntity<List<AnimalGenus>> getAnimalGenuses() {

		return new ResponseEntity<>((List<AnimalGenus>) animalGenusRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/saveanimalgenus", method = RequestMethod.POST)
	public AnimalGenus saveAnimalGenus(@RequestBody AnimalGenus requestAnimalGenus) {
		return animalGenusRepository.save(requestAnimalGenus);
	}
	
	@RequestMapping(value = "/deleteanimalgenus", method = RequestMethod.POST)
	public ResponseEntity<?> deleteAnimalGenus(@RequestParam Long id){
		
		Optional<AnimalGenus> animalGenus = animalGenusRepository.findById(id);
		return animalGenus.isPresent() ? 
		  ResponseEntity.ok().build() : ResponseEntity.notFound().build();
		
	}
}
