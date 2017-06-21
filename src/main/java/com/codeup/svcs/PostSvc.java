package com.codeup.svcs;

import com.codeup.controlers.PostsController;
import com.codeup.models.Post;
import org.springframework.stereotype.Service;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bichtran on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {
    //private List<Post> posts;
    List<Post> posts = new ArrayList<>();

    public PostSvc() { createPosts();

    }

    //    retrieving all the posts
    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post){
        post.setId((long)posts.size() + 1); //Array is index 0
        posts.add(post);
        return post;
    }
    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }
    //Create a few test posts so that you have some data that you can test.
    private void createPosts() {
        posts = new ArrayList<>();

         save(new Post("playstation for sale", "$1000 OBO"));
         save(new Post("xbox for sale", "$1000 OBO"));
    }
    //Create a new post
    public void createPost(String title, String body){
        save(new Post(title, body));
    }
}