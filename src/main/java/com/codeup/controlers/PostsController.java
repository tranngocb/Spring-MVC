package com.codeup.controlers;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bichtran on 6/19/17.
 */
@Controller
public class PostsController {

    private final PostSvc postSvc;

    @Autowired
    public PostsController(PostSvc postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {
        Iterable<Post> posts = postSvc.findAll();
        //List<Post> posts = postSvc.findAll(); remove the previous lis
        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        // Inside the method that shows an individual post, create a new post object and pass it to the view.
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    //@ResponseBody
    public String showPostForm(Model model) {
        model.addAttribute("post",new Post()); // This method should pass a new (i.e. empty) Post object to the view.

        return "posts/create";
    }
    //Use what you have learned in this lesson to have the post creation form submit a post object and store that post
    // with the posts service.

    @PostMapping("/posts/create")
    public String savePost(
        @RequestParam(name = "title") String title,// String title = request.getParameter("title")
        @RequestParam(name = "body") String body,
        Model model  // Model model = new Model();
        ) {
        Post post= new Post(title,body);
        model.addAttribute("post",post);

        return "/posts/create";
    }
    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        // TODO: Find this post in the data source using the service
        Post post = postSvc.findOne(id);
        // TODO: Pass the post found to the view
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();
    }
}