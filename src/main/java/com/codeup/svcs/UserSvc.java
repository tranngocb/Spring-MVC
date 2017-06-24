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
@Service("userSvc")
public class UserSvc {

    private UsersRepository usersDao; //Declare  type UsersRepository Step 1
    List<User> users = new ArrayList<>();
    //The contractor
    @Autowired
    public UserSvc(UsersRepository userDao) {
        this.usersDao = userDao;
    }

    public Iterable<User> findAll(){
        return usersDao.findAll();  // select * from posts
    }

    public User findOne(long id){
        return usersDao.findOne(id); // select * from posts where id = ?
    }

    public User save(User user){
        usersDao.save(user); // insert into posts(title, body) values (?, ?)
        return user;
    }

    public void deletePost(long id){
        usersDao.delete(id);
    }


}
