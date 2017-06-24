package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by bichtran on 6/23/17.
 */
public interface Users extends CrudRepository<User,Long> {
    public User findByUsername(String username);
}
