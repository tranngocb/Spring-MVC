package com.codeup.svcs;

import com.codeup.controlers.PostsController;
import com.codeup.models.Post;
import com.codeup.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bichtran on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {
    //private List<Post> posts;
    //List<Post> posts = new ArrayList<>();

    private PostsRepository postsDao;  //Declare  type PostsRepository

    //The contractor
    @Autowired
    public PostSvc(PostsRepository postDao) {
        this.postsDao = postDao;
//        createPosts();
    }

    // select * from posts
    public Iterable<Post> findAll(){
        return postsDao.findAll();
//Add a save method to your PostsSvc. It should take in a Post object, set it's id property, and add it to the list of posts.
        // select * from posts
        }

    public Post save(Post post){

        return postsDao.save(post);  //insert into poss(title,body) value (?,?)
    }

//    private void createPosts() {
//        save(new Post("ps4", "shiny and new"));
//        save(new Post("xbox juan", "not so shiny and new"));
//    }
    public Post findOne(long id) {
        return postsDao.findOne(id);
    }

    public void deletePost(long id){
        postsDao.delete(id);}
}
