package com.meritamerica.assignment7.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.assignment7.model.MyUser;


@Repository
public interface UserRepository extends JpaRepository<MyUser, Long>{
	List<MyUser> findAll();
	
	Optional<MyUser> findByUsername(String username);
	
	Optional<MyUser> findById(Long id);

	Boolean existsByUsername(String username);
}
