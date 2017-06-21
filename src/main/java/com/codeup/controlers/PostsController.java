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
    public String posts() {
        return "Post index Page";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String viewIndividual(@PathVariable long id) {
        return "view an individual post with ID " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showPostsForm() {
        return "view the form for creating a post";
    }

    //POST	/posts/create	view the form for creating a post
    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return "create a new post";
    }

    @GetMapping("/posts/{title}/{body}")
    public String showIndividual(@PathVariable String title, @PathVariable String body, Model model) {
        Post post = new Post(title, body);
//            String indTitle = post.getTitle();
//            post.getBody();
        model.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping("/posts/allpost")
    public String showAllPost(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("First title","Body for 1st post"));
        posts.add(new Post("Second title","Body for the second post"));
        model.addAttribute("posts", posts);
//        List<String> list2 = new ArrayList<>();
//        list2.add("Second  title");
//        list2.add("Seconf Body");

//        return null;
    return "/posts/index";
    }
}
