package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.User;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface IUserRepository extends CrudRepository<User, Long>{
    User save(User user);
    List<User> getAll();
    User matchCredentials(User user);
}
