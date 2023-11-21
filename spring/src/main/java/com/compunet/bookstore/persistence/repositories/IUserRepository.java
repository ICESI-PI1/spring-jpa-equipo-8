package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface IUserRepository extends CrudRepository<User, Long>{
    User matchCredentials(User user);

    Optional<User> findByUsername(String username);
}
