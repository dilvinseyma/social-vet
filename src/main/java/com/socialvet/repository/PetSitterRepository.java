package com.socialvet.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.socialvet.model.PetSitter;

public interface PetSitterRepository extends CrudRepository<PetSitter, Long> {

	@Query(value = "SELECT * FROM PETSITTER WHERE USERNAME = :username", nativeQuery = true)
	public PetSitter findByUsername(@Param("username") String username);
}
