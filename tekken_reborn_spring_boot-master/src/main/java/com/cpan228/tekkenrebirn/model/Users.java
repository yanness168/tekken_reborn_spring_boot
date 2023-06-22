package com.cpan228.tekkenrebirn.model;

import com.cpan228.tekkenrebirn.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class Users {
    private final UserRepository userRepository;

    public Users(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(RegistrationForm registrationForm) {
        userRepository.save(registrationForm);
    }

    public RegistrationForm findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isEmailRegistered(String email) {
        return userRepository.existsByEmail(email);
    }
}
