package com.codeup.svcs;

import com.codeup.controlers.PostsController;
import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.PostsRepository;
import com.codeup.repositories.UsersRepository;
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

    private PostsRepository postsDao;  //Declare  type PostsRepository Step 1
    List<Post> posts = new ArrayList<>();
    //The contractor
    @Autowired
    public PostSvc(PostsRepository postDao) {
        this.postsDao = postDao;
    }

    public Iterable<Post> findAll(){
        return postsDao.findAll();  // select * from posts
    }

    public Post findOne(long id){
        return postsDao.findOne(id); // select * from posts where id = ?
    }

    public Post save(Post post){
        postsDao.save(post); // insert into posts(title, body) values (?, ?)
        return post;
    }

    public void deletePost(long id){
        postsDao.delete(id);
    }


}
