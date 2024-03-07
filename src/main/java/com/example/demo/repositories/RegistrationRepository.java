package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	
}
