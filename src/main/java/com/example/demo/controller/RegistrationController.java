package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Registration;
import com.example.demo.services.RegistrationService;

import java.util.List;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Handler for displaying all registrations
    @GetMapping
    public String getAllRegistrations(Model model) {
        // Retrieve all registrations from the service
        List<Registration> registrations = registrationService.getAllRegistrations();
        // Add the list of registrations to the model for rendering in the view
        model.addAttribute("registrations", registrations);
        // Return the name of the view template to be rendered
        return "registrations";
    }

    // Handler for displaying a specific registration by ID
    @GetMapping("/{id}")
    public String getRegistrationById(@PathVariable Long id, Model model) {
        // Retrieve a specific registration by ID from the service
        registrationService.getRegistrationById(id).ifPresent(registration -> model.addAttribute("registration", registration));
        // Return the name of the view template to be rendered
        return "registration";
    }

    // Handler for displaying a form to create a new registration
    @GetMapping("/new")
    public String newRegistrationForm(Model model) {
        // Add a new empty Registration object to the model for the form
        model.addAttribute("registration", new Registration());
        // Return the name of the view template to be rendered
        return "newRegistration";
    }

    // Handler for handling the submission of the new registration form
    @PostMapping("/new")
    public String createRegistration(@ModelAttribute Registration registration) {
        // Save or update the registration using the service
        registrationService.saveOrUpdateRegistration(registration);
        // Redirect to the list of registrations after successful submission
        return "redirect:/registrations";
    }

    // Handler for displaying a form to edit an existing registration
    @GetMapping("/edit/{id}")
    public String editRegistrationForm(@PathVariable Long id, Model model) {
        // Retrieve an existing registration by ID from the service for editing
        registrationService.getRegistrationById(id).ifPresent(registration -> model.addAttribute("registration", registration));
        // Return the name of the view template to be rendered
        return "editRegistration";
    }

    // Handler for handling the submission of the updated registration form
    @PostMapping("/edit")
    public String updateRegistration(@ModelAttribute Registration registration) {
        // Save or update the registration using the service
        registrationService.saveOrUpdateRegistration(registration);
        // Redirect to the list of registrations after successful update
        return "redirect:/registrations";
    }

    // Handler for deleting a registration by ID
    @GetMapping("/delete/{id}")
    public String deleteRegistration(@PathVariable Long id) {
        // Delete the registration by ID using the service
        registrationService.deleteRegistration(id);
        // Redirect to the list of registrations after successful deletion
        return "redirect:/registrations";
    }
}
