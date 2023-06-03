package com.cpan228.tekkenrebirn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping("/")
    //If you want to return a string, you need to add @ResponseBody
    public String redirectToAbout() {
        return "redirect:/about";
    }

    @GetMapping("/about")
    public String greeting() {
        return "about";
    }
}

