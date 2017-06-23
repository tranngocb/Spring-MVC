package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bichtran on 6/22/17.
 */
@Repository
public interface PostsRepository extends CrudRepository<Post,Long> {
    Post findByTitle(String title);
    // Finds a list of ads that matches something like the title.
    List<Post> findByTitleIsLike(String title);
}
