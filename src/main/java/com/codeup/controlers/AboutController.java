package com.codeup.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by bichtran on 6/19/17.
 */
@Controller
public class AboutController {
@GetMapping("/about")
    public String myView(){

    return "resume";
}
    @GetMapping("/about/portfolio")
    public String myPortFolio(){

        return "portfolio";
    }

}
