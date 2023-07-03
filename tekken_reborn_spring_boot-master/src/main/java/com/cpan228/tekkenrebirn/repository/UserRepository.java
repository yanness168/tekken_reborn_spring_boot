package com.cpan228.tekkenrebirn.repository;

import com.cpan228.tekkenrebirn.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

