package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Registration;
import com.example.demo.repositories.RegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    // Get all registrations from the repository
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    // Get a specific registration by ID from the repository
    public Optional<Registration> getRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }

    // Save or update a registration in the repository
    public Registration saveOrUpdateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    // Delete a registration by ID from the repository
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}
