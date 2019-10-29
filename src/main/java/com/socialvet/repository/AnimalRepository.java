package com.socialvet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.socialvet.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long>{

	@Query(value = "SELECT * FROM ANIMAL WHERE NAME = :animalName", nativeQuery = true)
	public List<Animal> findAnimalsByName(@Param("animalName") String animalName);
	
	@Query(value = "SELECT * FROM ANIMAL WHERE PETSITTER_USERNAME = :petSitterUsername", nativeQuery = true)
	public List<Animal> findAnimalsByPetSitterUsername(@Param("petSitterUsername") String petSitterUsername);

	@Query(value = "SELECT * FROM ANIMAL WHERE STATUS = true", nativeQuery = true)
	public List<Animal> findAllActiveAnimals();
}
