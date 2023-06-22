package com.cpan228.tekkenrebirn.repository;

import com.cpan228.tekkenrebirn.model.RegistrationForm;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<RegistrationForm, Long> {
    RegistrationForm findByEmail(String email);

    boolean existsByEmail(String email);
}
