package com.codeup.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bichtran on 6/19/17.
 */
@Controller
public class MathController {
    @GetMapping("/add/{firstNumber}/and/{secondNumber}")
    @ResponseBody
    public String add(@PathVariable long firstNumber, @PathVariable long secondNumber ){
        String addLong=String.valueOf(firstNumber + secondNumber).toString();
    return String.format("Add %s : ",addLong);
    }
    @GetMapping("/subtract/{firstNumber}/from/{secondNumber}")
    @ResponseBody
    public String subtract(@PathVariable long firstNumber, @PathVariable long secondNumber ){
        String subLong=String.valueOf(firstNumber - secondNumber).toString();
        return String.format("Subtract %s : ",subLong);
    }
    @GetMapping("/multiply/{firstNumber}/{secondNumber}")
    @ResponseBody
    public String multiply(@PathVariable long firstNumber, @PathVariable long secondNumber ){
        String multiplyLong=String.valueOf(firstNumber * secondNumber).toString();
        return String.format("Multiply two numbers: %s : ",multiplyLong);
    }
    @GetMapping("/divi/{firstNumber}/and/{secondNumber}")
    @ResponseBody
    public String divi(@PathVariable long firstNumber, @PathVariable long secondNumber ){
        //Need validation
        String diviLong=String.valueOf(firstNumber/ secondNumber).toString();

        return String.format("Divide two numbers: %s : ",diviLong);
    }
}
