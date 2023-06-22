package com.cpan228.tekkenrebirn.controllers;

import com.cpan228.tekkenrebirn.model.RegistrationForm;
import com.cpan228.tekkenrebirn.model.Users;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    private final Users users;

    @Autowired
    public RegistrationController(Users users) {
        this.users = users;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("registrationForm") @Valid RegistrationForm registrationForm, BindingResult bindingResult) {
        if(registrationForm.getUsername().isBlank()){
            bindingResult.rejectValue("username", "registrationForm.username", "Username cannot be blank");
            return "registration";
        }
        if(registrationForm.getEmail().isBlank()){
            bindingResult.rejectValue("email", "registrationForm.email", "Email cannot be blank");
            return "registration";
        }
        if(registrationForm.getPassword().isBlank()){
            bindingResult.rejectValue("password", "registrationForm.password", "Password cannot be blank");
            return "registration";
        }

        // Check if the email is already registered
        if (users.isEmailRegistered(registrationForm.getEmail())) {
            bindingResult.rejectValue("email", "registrationForm.email", "This email has been registered. Please log in or try using another email.");
            return "registration";
        }

        System.out.println("Submitted user: " + registrationForm);
        users.saveUser(registrationForm); // Process registration and save user
        System.out.println(registrationForm.getId());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        if (email.isEmpty() || password.isEmpty()) {
            // Empty email or password, inform the user
            redirectAttributes.addFlashAttribute("error", "Please enter both email and password");
            return "redirect:/login";
        }

        var user = users.findByEmail(email);
        System.out.println(user);
        if (user == null || !user.getPassword().equals(password)) {
            // Incorrect credentials, inform the user
            redirectAttributes.addFlashAttribute("error", "Incorrect email or password");
            return "redirect:/login";
        } else {
            // Correct credentials, redirect to the home page
            return "redirect:/";
        }
    }

}
