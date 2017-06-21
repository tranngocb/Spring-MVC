package com.codeup.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by bichtran on 6/19/17.
 */
@Controller
public class RollDiceController {
    @GetMapping("/roll/{number}")
    public String rolling(@PathVariable int number, Model model) {

        int generatedNumber = 5;
        model.addAttribute("numberRoll", number);
        boolean guess;
        //We only dispaly the message at roll-dice if  generatedNumber IS NOT == number
        if (generatedNumber == number) {
            guess = false;
            model.addAttribute("guess", guess);
        } else{guess=true;
            model.addAttribute("guess", guess);}

        return "roll-dice";


    }
}
