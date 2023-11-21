package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface IUserRepository extends CrudRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(String username);
}
