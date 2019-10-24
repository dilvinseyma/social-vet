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
import com.socialvet.model.PetSitter;
import com.socialvet.repository.PetSitterRepository;

@RestController
@CrossOrigin(origins = "*")
public class PetSitterController {

	@Autowired
	private PetSitterRepository petSitterRepository;
	
	@RequestMapping(value = "/petsitters", method = RequestMethod.POST)
	public ResponseEntity<List<PetSitter>> getPetSitters(){
		
		return new ResponseEntity<>((List<PetSitter>)petSitterRepository.findAll(), HttpStatus.OK);
	}
	
	// also used for update, when id present in request
	@RequestMapping(value = "/savepetsitter", method = RequestMethod.POST)
	public ResponseEntity<PetSitter> savePetSitter(@RequestBody PetSitter requestPetSitter){
		return new ResponseEntity<>(petSitterRepository.save(requestPetSitter), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/deletepetsitter", method = RequestMethod.POST)
	public ResponseEntity<?> deletePetSitter(@RequestParam Long id){
		
		Optional<PetSitter> petSitterToDelete = petSitterRepository.findById(id);
		
		if(petSitterToDelete.isPresent()) {
			PetSitter petSitter = petSitterToDelete.get();
			petSitter.setStatus(false);
			petSitterRepository.save(petSitter);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@RequestMapping(value = "/petsitterbyusername", method = RequestMethod.POST)
	public ResponseEntity<PetSitter> getPetSitterByUsername(@RequestBody JsonNode request){
		String username = request.findValue("username").asText();
		
		PetSitter petSitter = petSitterRepository.findByUsername(username);
		return new ResponseEntity<>(petSitter, HttpStatus.OK);
	}
}
