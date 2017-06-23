package com.codeup.repositories;

import com.codeup.models.Post;
import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bichtran on 6/22/17.
 */
@Repository
public interface UsersRepository extends CrudRepository<User,Long> {
    User findUserByUsername(String username);

    List<User> findUserByUsernameLike(String username);
}
}
